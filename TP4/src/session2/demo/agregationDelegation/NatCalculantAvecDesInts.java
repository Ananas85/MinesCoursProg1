package session2.demo.agregationDelegation;

public class NatCalculantAvecDesInts extends NatDeleguantEtat implements Nat{

	
	public NatCalculantAvecDesInts(EtatNaturelPur e) {
		super(e);
	}

	@Override
	protected Nat creerNatAvecEtat(EtatNaturelPur e){
		return new NatCalculantAvecDesInts(e);
	}
	
	@Override
	public Nat somme(Nat x) {
		return this.creerNatAvecValeur(this.val() + x.val());
	}

	@Override
	public Nat zero() {
		return this.creerNatAvecValeur(0);
	}
	
	@Override
	public Nat produit(Nat x) {
		return this.creerNatAvecValeur(this.val() * x.val());
	}

	@Override
	public Nat un() {
		return this.creerNatAvecValeur(1);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Nat))
			return false;
		Nat x = (Nat)obj;
		return this.val() == x.val();

	}

}
