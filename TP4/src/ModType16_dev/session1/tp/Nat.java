package ModType16_dev.session1.tp;

import ModType16_dev.hierarchie.SemiAnneauUnitaire;

public interface Nat extends SemiAnneauUnitaire<Nat>, FabriqueNaturels<Nat>{
	int val();
	boolean estNul();
	Nat predecesseur();
}
