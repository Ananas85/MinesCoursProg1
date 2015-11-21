package session2.demo.heritageMultiple;

import session1.tp.Nat;

public class NatParIntRecursif extends IntPositif implements FabriqueNatParDefaut, AlgebreNatRecursif, Nat {

	public NatParIntRecursif(int val) {
		super(val);
	}

	@Override
	public Nat creerNatAvecValeur(int val) {
		return new NatParIntRecursif(val);
	}

	@Override
	public boolean equals(Object obj) {
		return this.estEgal(obj);
	}
}
