package ModType16_dev.session2.demo.agregationDelegation;

public interface Nat extends EtatNaturel<Nat>, ModType16_dev.hierarchie.SemiAnneauUnitaire<Nat>, ModType16_dev.session1.tp.FabriqueNaturels<Nat>{
	EtatNaturelPur etat();
}
