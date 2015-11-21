package session2.demo.heritageMultiple;

import session1.tp.Nat;

public interface AlgebreNatRecursif extends Nat{

	@Override
	default public Nat somme( Nat x ) {
		if(this.estNul())
			return x;
		return this.creerSuccesseur(this.predecesseur().somme(x));
	}

	@Override
	default public Nat zero() {
		return this.creerZero();
	}

	@Override
	default public Nat produit( Nat x ) {
		if(this.estNul())
			return this.zero();
		return x.somme(this.predecesseur().produit(x));
	}

	@Override
	default public Nat un() {
		return this.creerSuccesseur(this.zero());
	}

	default public boolean estEgal( Object obj ) {
		if(!(obj instanceof Nat))
			return false;
		Nat x = (Nat)obj;
		if(this.estNul())
			return x.estNul();
		if(x.estNul())
			return false;
		return this.predecesseur().equals(x.predecesseur());
	}


}
