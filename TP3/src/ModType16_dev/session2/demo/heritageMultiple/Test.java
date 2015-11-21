package ModType16_dev.session2.demo.heritageMultiple;

import ModType16_dev.session1.tp.FabriqueNaturels;
import ModType16_dev.session1.tp.Nat;

public class Test {

	private static void test(FabriqueNaturels<Nat> fabN) {
		System.out.println("Test de la classe " + fabN.getClass());
		Nat nA = fabN.creerZero();
		System.out.println("true ( 0 = 0) ? " + nA.equals(nA.zero()));
		nA = fabN.creerSuccesseur(nA);
		System.out.println("true ( 1 = 1) ? " + nA.equals(nA.un()));
		nA = fabN.creerNatAvecValeur(5);
		Nat nB = fabN.creerNatAvecValeur(3);
		System.out.println("8 (5 + 3) ? " + nA.somme(nB));
		System.out.println("15 (5 * 3) ? " + nA.produit(nB));
	}

	public static void main(String[] args) {
		test(new NatParInt(0));
		test(new ZeroRecursif());
		test(new SuccRecursif(new ZeroRecursif()));
		test(new NatParIntRecursif(0));
		test(new ZeroInductifCalculantAvecDesInts());
		test(new SuccInductifCalculantAvecDesInts(new ZeroInductifCalculantAvecDesInts()));
	}
}
