package session2.demo.heritageMultiple;

import session1.tp.Nat;

public class SuccInductifCalculantAvecDesInts extends Succ implements FabriqueNatParDefaut, AlgebreNatParInt, Nat {
	
	public SuccInductifCalculantAvecDesInts(Nat predecesseur) {
		super(predecesseur);
	}

	@Override
	public Nat creerZero() {
		return new ZeroRecursif();
	}

	@Override
	public Nat creerSuccesseur(Nat predecesseur) {
		return new SuccInductifCalculantAvecDesInts(predecesseur);
	}

	@Override
	public boolean equals(Object obj) {
		return this.estEgal(obj);
	}
}
