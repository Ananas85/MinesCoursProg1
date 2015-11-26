package ModType16_dev.session2.demo.heritageDescendant;

import ModType16_dev.session1.tp.Nat;

public class SuccRec extends Succ implements Nat {

	public SuccRec(Nat predecesseur) {
		super(predecesseur);
	}

	@Override
	public Nat creerZero() {
		return new ZeroRec();
	}

	@Override
	public Nat creerSuccesseur(Nat predecesseur) {
		return new SuccRec(predecesseur);
	}

	@Override
	public Nat somme(Nat x) {
		return this.creerSuccesseur(this.predecesseur().somme(x));
	}

	@Override
	public Nat produit(Nat x) {
		return x.somme(this.predecesseur().produit(x));
	}


	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Nat))
			return false;
		Nat x = (Nat)obj;
		if(x.estNul())
			return false;
		return this.predecesseur().equals(x.predecesseur());
	}

}
