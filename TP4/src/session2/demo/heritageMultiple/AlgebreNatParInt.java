package session2.demo.heritageMultiple;

import session1.tp.Nat;

public interface AlgebreNatParInt extends Nat {
	@Override
	default public Nat zero() {
		return this.creerNatAvecValeur(0);
	}

	@Override
	default public Nat somme( Nat x ) {
		return this.creerNatAvecValeur(this.val() + x.val());
	}

	@Override
	default public Nat un() {
		return this.creerNatAvecValeur(1);
	}

	@Override
	default public Nat produit( Nat x ) {
		return this.creerNatAvecValeur(this.val() * x.val());
	}

	default public boolean estEgal( Object obj ) {
		if(!(obj instanceof Nat))
			return false;
		Nat x = (Nat)obj;
		return this.val() == x.val();
	}



}
