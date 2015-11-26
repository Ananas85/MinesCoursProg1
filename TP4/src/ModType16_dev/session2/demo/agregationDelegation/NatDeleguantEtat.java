package ModType16_dev.session2.demo.agregationDelegation;

public abstract class NatDeleguantEtat implements Nat{

	// Délégation
	private EtatNaturelPur etat;
	
	public NatDeleguantEtat(EtatNaturelPur e) {
		this.etat = e;
	}

	@Override
	public EtatNaturelPur etat() {
		return this.etat;
	}
	
	protected abstract Nat creerNatAvecEtat(EtatNaturelPur predecesseur);

	@Override
	public int val() {
		return this.etat().val();
	}

	@Override
	public boolean estNul() {
		return this.etat().estNul();
	}

	@Override
	public Nat predecesseur() {
		return this.creerNatAvecEtat(this.etat().predecesseur());
	}

	@Override
	public Nat creerNatAvecValeur(int val) {
		return this.creerNatAvecEtat(this.etat().creerNatAvecValeur(val));
	}

	@Override
	public Nat creerZero() {
		return this.creerNatAvecEtat(this.etat().creerZero());
	}

	@Override
	public Nat creerSuccesseur(Nat predecesseur) {
		return this.creerNatAvecEtat(
				this.etat().creerSuccesseur(
							predecesseur.etat()));
	}
	
	@Override
	public String toString() {
		return this.etat().toString();
	}

}
