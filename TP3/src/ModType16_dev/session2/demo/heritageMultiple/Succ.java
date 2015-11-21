package ModType16_dev.session2.demo.heritageMultiple;

import ModType16_dev.session1.tp.Nat;

public abstract class Succ implements Nat {

	private Nat predecesseur;

	public Succ(Nat predecesseur) {
		this.predecesseur = predecesseur;
	}

	@Override
	public int val() {
		return 1 + this.predecesseur().val();
	}

	@Override
	public boolean estNul() {
		return false;
	}

	@Override
	public Nat predecesseur() {
		return this.predecesseur;
	}
	@Override
	public String toString() {
		return "S^" + this.val() + "(0)";
	}
	
}
