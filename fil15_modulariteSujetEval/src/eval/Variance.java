package eval;

import java.util.LinkedList;
import java.util.List;

class A {
}

class B extends A {
	public void f() {
	}
}
public class Variance {


	// A utiliser pour convertir de List<B> en List<A>
	@SuppressWarnings("unchecked")
	private static List<A> covariance(List<B> l) {
		// pas d'erreur à l'exécution : les types arguments sont effacés.
		return (List<A>) (List<?>) l;
	}

	// A utiliser pour convertir de List<A> en List<B>
	@SuppressWarnings("unchecked")
	private static List<B> contravariance(List<A> l) {
		// pas d'erreur à l'exécution : les types arguments sont effacés.
		return (List<B>) (List<?>) l;
	}

	// Q2 TODO
	@SuppressWarnings("unchecked")
	private static <T> List covarianceG(List<? extends T> l) {
		return (List<T>) (List<?>) l;
	}

	// Q2 TODO
	@SuppressWarnings("unchecked")
	private static <T> List contravarianceG(List<? super T> l) {
		return (List<T>) (List<?>) l;
	}

	public static void main(String[] args) {
		erreurCovariance();
		erreurContravariance();
		erreurCovarianceG();
		erreurContravarianceG();
	}

	private static void erreurCovariance() {
		try {
			List<B> listB = new LinkedList<>(  );
			List<A> listA = covariance( listB ); //cast to A de ListB -> reference
			listA.add( new A() );
			listB.get(0).f();
		} catch (Exception e) {
			System.out.println("Covariance bugue");
			e.printStackTrace(System.out);
		}
	}

	private static void erreurContravariance() {
		try {
			List<A> lA = new LinkedList<>();
			lA.add(new A());
			List<B> lB = contravariance(lA);
			lB.get(0).f();
		} catch (Exception e) {
			System.out.println("contravariance bugue");
			e.printStackTrace(System.out);
		}
	}

	private static void erreurCovarianceG() {
		try {
			List<B> lB = new LinkedList<>();
			List<A> lA = covarianceG(lB); // 1 pour l'intanciation
			lA.add(new A());
			lB.get(0).f();
		} catch (Exception e) {
			System.out.println("Probleme covariance g");
			e.printStackTrace(System.out);
		}
	}

	private static void erreurContravarianceG() {
		try {
			List<A> lA = new LinkedList<>();
			lA.add(new A());
			List<B> lB = contravarianceG(lA);
			lB.get(0).f();
		} catch (Exception e) {
			System.out.println("Probleme contravariance g");
			e.printStackTrace(System.out);
		}
	}

}
