package eval;

public class Test {
	public static void main(String[] args) {
		/*
		 * Question 2.4 : test de Zero, Succ et Nat
		 */
		FabriqueNats<Nat> fabriqueNats = Zero.SINGLETON;

		Nat zero = fabriqueNats.creer();

		Nat un = fabriqueNats.creer( zero );

		Nat deux = fabriqueNats.creer( un );

		Nat quatre = deux.somme( deux );

		Nat huit = quatre.produit( deux );

		System.out.println("TEST DE LA QUESTION 2.4 -> TEST DES SUCC ET ZERO");
		System.out.println(" 0 ??? " + zero);
		System.out.println(" 1 ??? " + un);
		System.out.println(" 2 ??? " + deux);
		System.out.println(" 4 ??? " + quatre);
		System.out.println(" 8 ??? " + huit);
		/*
		 * Question 3.3 : test de Relatif et Z
		 */

		/*
		 * Question 3.5 : test de Diagonale<Nat> et Symetrise<Nat>
		 */

	}
}