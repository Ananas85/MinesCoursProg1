package ModType16_dev.session2.demo.heritageDescendant;

import ModType16_dev.session1.tp.Nat;

public abstract class FabriqueNatParDefaut implements Nat {
	@Override
	public Nat creerZero() {
		return this.creerNatAvecValeur(0);
	}

	@Override
	public Nat creerSuccesseur(Nat predecesseur) {
		return this.creerNatAvecValeur(predecesseur.val() + 1);
	}
	@Override
	public Nat creerNatAvecValeur(int val) {
		if(val < 0)
			throw new IllegalArgumentException();
		if (val == 0)
			return this.creerZero();
		return this.creerSuccesseur(this.creerNatAvecValeur(val - 1));
	}
}
