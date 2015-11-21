package session1.tp;

public class ZeroRec extends Zero implements Nat {

	@Override
	public Nat somme(Nat x) {
		return x;
	}

	@Override
	public Nat produit(Nat x) {
		return this.creerZero();
	}

	@Override
	public Nat creerSuccesseur(Nat predecesseur) {
		return new SuccRec(predecesseur);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Nat))
			return false;
		Nat x = (Nat)obj;
		return x.estNul();
	}

}
