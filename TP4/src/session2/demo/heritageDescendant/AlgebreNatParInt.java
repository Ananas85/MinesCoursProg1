package session2.demo.heritageDescendant;

import session1.tp.Nat;

public abstract class AlgebreNatParInt extends FabriqueNatParDefaut implements Nat {
	@Override
	public Nat zero() {
		return this.creerNatAvecValeur(0);
	}
	@Override
	public Nat somme(Nat x) {
		return this.creerNatAvecValeur(this.val() + x.val());
	}

	@Override
	public Nat un() {
		return this.creerNatAvecValeur(1);
	}

	@Override
	public Nat produit(Nat x) {
		return this.creerNatAvecValeur(this.val() * x.val());
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Nat))
			return false;
		Nat x = (Nat)obj;
		return this.val() == x.val();
	}


}
