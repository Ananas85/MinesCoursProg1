package ModType16_dev.session2.demo.agregationDelegation;

public class NatCalculantRecursivement extends NatDeleguantEtat implements Nat {

	public NatCalculantRecursivement(EtatNaturelPur etat) {
		super(etat);
	}

	@Override
	protected Nat creerNatAvecEtat(EtatNaturelPur etat) {
		return new NatCalculantRecursivement(etat);
	}

	public Nat zero() {
		return this.creerZero();
	}

	public Nat somme(Nat x) {
		if (this.estNul())
			return x;
		return this.creerSuccesseur(this.predecesseur().somme(x));
	}

	public Nat produit(Nat x) {
		if (this.estNul())
			return this.zero();
		return x.somme(this.predecesseur().produit(x));
	}

	public Nat un() {
		return this.creerSuccesseur(this.zero());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Nat))
			return false;
		Nat x = (Nat) obj;
		if (this.estNul())
			return x.estNul();
		if (x.estNul())
			return false;
		return this.predecesseur().equals(x.predecesseur());
	}

}
