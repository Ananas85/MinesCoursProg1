package session1.tp;

public class NatParInt implements Nat {
	
	private int val;

	public NatParInt(int val){
		if(val < 0)
			throw new IllegalArgumentException("Pas de Nat à patir d'un int négatif.");
		this.val = val;
	}
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
	public Nat creerNatAvecValeur(int val) {
		return new NatParInt(val);
	}

	@Override
	public Nat creerZero() {
		return this.creerNatAvecValeur(0);
	}

	@Override
	public Nat creerSuccesseur(Nat predecesseur) {
		return this.creerNatAvecValeur(predecesseur.val() + 1);
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
		if(this.estNul())
			throw new UnsupportedOperationException("Pas de prédécesseur.");
		return this.creerNatAvecValeur(this.val() - 1);
	}
	@Override
	public String toString() {
		return Integer.toString(this.val());
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Nat))
			return false;
		Nat x = (Nat)obj;
		return this.val() == x.val();
	}

}