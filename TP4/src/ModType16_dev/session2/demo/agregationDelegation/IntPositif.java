package ModType16_dev.session2.demo.agregationDelegation;

public class IntPositif implements EtatNaturelPur {

	private int val;

	public IntPositif(int val) {
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
	public EtatNaturelPur predecesseur() {
		return this.creerNatAvecValeur(this.val() -1);
	}

	public EtatNaturelPur creerNatAvecValeur(int val) {
		if(val < 0)
			throw new IllegalArgumentException();
		return new IntPositif(val);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof EtatNaturelPur)){
			return false;
		}
		EtatNaturelPur x = (EtatNaturelPur)obj;
		return this.val() == x.val();
	}
	
	@Override
	public String toString() {
		return Integer.toString(this.val());
	}

}
