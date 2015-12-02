package eval;

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
	private static List covarianceG(List l) {
		return null;
	}

	// Q2 TODO
	@SuppressWarnings("unchecked")
	private static List contravarianceG(List l) {
		return null;
	}

	public static void main(String[] args) {
		erreurCovariance();
		erreurContravariance();
		erreurCovarianceG();
		erreurContravarianceG();
	}

	private static void erreurCovariance() {
		try {
			// Q1 TODO
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static void erreurContravariance() {
		try {
			// Q1 TODO
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static void erreurCovarianceG() {
		try {
			// Q2 TODO
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

	private static void erreurContravarianceG() {
		try {
			// Q2 TODO
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

}
