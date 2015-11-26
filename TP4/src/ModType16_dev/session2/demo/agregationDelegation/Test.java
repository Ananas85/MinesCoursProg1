package ModType16_dev.session2.demo.agregationDelegation;

import ModType16_dev.session1.tp.FabriqueNaturels;

public class Test {

	private static void test(FabriqueNaturels<Nat> fabN) {
		Nat nA = fabN.creerZero();
		System.out.println("Test de la classe " + fabN.getClass() 
			    + " avec état " + nA.etat().getClass());
		System.out.println("true ( 0 = 0) ? " + nA.equals(nA.zero()));
		nA = fabN.creerSuccesseur(nA);
		System.out.println("true ( 1 = 1) ? " + nA.equals(nA.un()));
		nA = fabN.creerNatAvecValeur(5);
		Nat nB = fabN.creerNatAvecValeur(3);
		System.out.println("8 (5 + 3) ? " + nA.somme(nB));
		System.out.println("15 (5 * 3) ? " + nA.produit(nB));
	}

	public static void main(String[] args) {
		
		test(new NatCalculantAvecDesInts(new IntPositif(0)));
		test(new NatCalculantAvecDesInts(new ZeroInductif()));
		test(new NatCalculantAvecDesInts(new SuccInductif(new ZeroInductif())));
		test(new NatCalculantRecursivement(new IntPositif(0)));
		test(new NatCalculantRecursivement(new ZeroInductif()));
		test(new NatCalculantRecursivement(new SuccInductif(new ZeroInductif())));
		
	}
}
