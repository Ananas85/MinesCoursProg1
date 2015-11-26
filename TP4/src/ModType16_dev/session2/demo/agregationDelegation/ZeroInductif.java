package ModType16_dev.session2.demo.agregationDelegation;

public class ZeroInductif implements EtatNaturelPur {

	@Override
	public int val() {
		return 0;
	}

	@Override
	public boolean estNul() {
		return true;
	}

	@Override
	public EtatNaturelPur predecesseur() {
		throw new UnsupportedOperationException("Pas de prédécesseur.");
	}

	@Override
	public EtatNaturelPur creerZero() {
		return this;
	}

	@Override
	public EtatNaturelPur creerSuccesseur(EtatNaturelPur predecesseur) {
		return new SuccInductif(predecesseur);
	}
	
	@Override
	public String toString() {
		return "0";
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof EtatNaturelPur))
			return false;
		EtatNaturelPur x = (EtatNaturelPur)obj;
		return x.estNul();
	}

}
