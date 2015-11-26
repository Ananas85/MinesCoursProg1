package ModType16_dev.session2.demo.agregationDelegation;

import ModType16_dev.session1.tp.FabriqueNaturels;

public interface EtatNaturelPur extends EtatNaturel<EtatNaturelPur>, FabriqueNaturels<EtatNaturelPur> {
	@Override
	default public EtatNaturelPur creerNatAvecValeur( int val ) {
		if(val < 0)
			throw new IllegalArgumentException();
		if (val == 0)
			return this.creerZero();
		return this.creerSuccesseur(this.creerNatAvecValeur(val - 1));
	}

	@Override
	default public EtatNaturelPur creerZero() {
		return this.creerNatAvecValeur(0);
	}

	@Override
	default public EtatNaturelPur creerSuccesseur( EtatNaturelPur predecesseur ) {
		return this.creerNatAvecValeur(predecesseur.val() + 1);	
	}
}
