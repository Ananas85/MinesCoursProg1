package session1.tp;

import hierarchie.SemiAnneauUnitaire;

public interface Nat extends SemiAnneauUnitaire<Nat>, FabriqueNaturels<Nat>{
	int val();
	boolean estNul();
	Nat predecesseur();
}
