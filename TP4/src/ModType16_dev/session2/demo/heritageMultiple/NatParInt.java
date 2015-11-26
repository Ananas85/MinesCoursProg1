package ModType16_dev.session2.demo.heritageMultiple;

import ModType16_dev.session1.tp.Nat;

public class NatParInt extends IntPositif implements FabriqueNatParDefaut, AlgebreNatParInt, Nat {

	public NatParInt(int val) {
		super(val);
	}

	@Override
	public Nat creerNatAvecValeur(int val) {
		return new NatParInt(val);
	}

	@Override
	public boolean equals(Object obj) {
		return this.estEgal(obj);
	}
}
