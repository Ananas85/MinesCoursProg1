package session2.demo.heritageMultiple;

import session1.tp.Nat;

public class ZeroInductifCalculantAvecDesInts extends Zero implements FabriqueNatParDefaut, AlgebreNatRecursif, Nat {

	@Override
	public Nat creerZero() {
		return this;
	}

	@Override
	public Nat creerSuccesseur(Nat predecesseur) {
		return new SuccRecursif(predecesseur);
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.estEgal(obj);
	}
	
}
