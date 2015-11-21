package session2.demo.agregationDelegation;

public interface Nat extends EtatNaturel<Nat>, hierarchie.SemiAnneauUnitaire<Nat>, session1.tp.FabriqueNaturels<Nat>{
	EtatNaturelPur etat();
}
