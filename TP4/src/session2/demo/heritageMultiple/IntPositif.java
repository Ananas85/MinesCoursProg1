package session2.demo.heritageMultiple;

import session1.tp.Nat;

public abstract class IntPositif implements Nat {

	private int val;

	public IntPositif(int val) {
		if(val < 0)
			throw new IllegalArgumentException();
		this.val = val;
	}

	@Override
	public int val() {
		return this.val;
	}

	@Override
	public boolean estNul() {
		return this.val() == 0;
	}

	@Override
	public Nat predecesseur() {
		return this.creerNatAvecValeur(this.val() - 1);
	}
	
	@Override
	public String toString() {
		return Integer.toString(this.val());
	}

}
