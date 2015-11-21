package ModType16_dev.session2.demo.agregationDelegation;

public class SuccInductif implements EtatNaturelPur {

	private EtatNaturelPur predecesseur;

	public SuccInductif(EtatNaturelPur predecesseur) {
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
	public EtatNaturelPur predecesseur() {
		return this.predecesseur;
	}

	@Override
	public EtatNaturelPur creerZero() {
		return new ZeroInductif();
	}

	@Override
	public EtatNaturelPur creerSuccesseur(EtatNaturelPur predecesseur) {
		return new SuccInductif(predecesseur);
	}

	@Override
	public String toString() {
		return "S^" + this.val() + "(0)";
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof EtatNaturelPur))
			return false;
		EtatNaturelPur x = (EtatNaturelPur)obj;
		if(x.estNul())
			return false;
		return this.predecesseur().equals(x.predecesseur());
	}
	
}
