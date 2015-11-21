package session2.demo.heritageMultiple;

import session1.tp.Nat;

public interface FabriqueNatParDefaut extends Nat {
	@Override
	default public Nat creerZero() {
		return this.creerNatAvecValeur(0);
	}

	@Override
	default public Nat creerSuccesseur( Nat predecesseur ) {
		return this.creerNatAvecValeur(predecesseur.val() + 1);
	}
	@Override
	default public Nat creerNatAvecValeur( int val ) {
		if(val < 0)
			throw new IllegalArgumentException();
		if (val == 0)
			return this.creerZero();
		return this.creerSuccesseur(this.creerNatAvecValeur(val - 1));
	}
}
