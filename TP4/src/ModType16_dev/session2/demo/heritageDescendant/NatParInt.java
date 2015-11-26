package ModType16_dev.session2.demo.heritageDescendant;

import ModType16_dev.session1.tp.Nat;

public class NatParInt extends AlgebreNatParInt implements Nat {

	private int val;

	public NatParInt(int val) {
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
	public Nat creerNatAvecValeur(int val) {
		return new NatParInt(val);
	}


	@Override
	public String toString() {
		return Integer.toString(this.val());
	}

}
