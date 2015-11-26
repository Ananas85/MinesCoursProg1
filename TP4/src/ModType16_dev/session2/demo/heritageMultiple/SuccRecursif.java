package ModType16_dev.session2.demo.heritageMultiple;

import ModType16_dev.session1.tp.Nat;

public class SuccRecursif extends Succ implements FabriqueNatParDefaut, AlgebreNatRecursif, Nat {
	
	public SuccRecursif(Nat predecesseur) {
		super(predecesseur);
	}

	@Override
	public Nat creerZero() {
		return new ZeroRecursif();
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
