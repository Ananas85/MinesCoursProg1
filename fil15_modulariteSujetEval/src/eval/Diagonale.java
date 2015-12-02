package eval;

import structuresAlgebriques.MonoideAdd;
import structuresAlgebriques.MonoideMul;

/*
 * Question 3.4 : généralisation Interface et classe d'implémentation génériques
 * pour la symétrisation
 */
class Diagonale<T extends MonoideAdd<T> & MonoideMul<T>> implements Symetrise<T> {
	private T positif;
	private T negatif;

	public Diagonale(T positif, T negatif) {
		this.positif = positif;
		this.negatif = negatif;
	}


	@Override
	public Symetrise<T> creer( T positif, T negatif ) {
		return new Diagonale<T>( positif, negatif );
	}

	@Override
	public Symetrise<T> oppose() {
		return new Diagonale<T>( negatif, positif );
	}

	@Override
	public Symetrise<T> zero() {
		return new Diagonale<T>( this.positif.zero(), this.positif.zero() );
	}

	@Override
	public Symetrise<T> un() {
		return new Diagonale<T>( this.positif.un(), this.positif.zero() );
	}

	@Override
	public Couple<T, T> val() {
		return new Couple<T, T>( this.positif, this.negatif );
	}

	@Override
	public Symetrise<T> somme( Symetrise<T> x ) {
		Couple<T, T> repX = x.val();
		return this.creer( this.positif.somme( repX.pi1 ), this.negatif.somme( repX.pi2 ) );
	}

	@Override
	public Symetrise<T> produit( Symetrise<T> x ) {
		Couple<T, T> repX = x.val();
		T positif = this.positif.produit( repX.pi1 ).somme( this.negatif.produit( repX.pi2 ) );
		T negatif = this.negatif.produit( repX.pi1 ).somme( this.positif.produit( repX.pi2 ) );
		return creer( positif, negatif );
	}

	@Override
	public String toString() {
		return String.valueOf( this.positif.toString() + "-" + this.negatif.toString() );
	}

	@Override
	public boolean equals( Object obj ) {
		try
		{
			@SuppressWarnings("unchecked")
			Symetrise<T> x = (Symetrise<T>) obj;
			Couple<T, T> repX = x.val();
			return this.positif.somme( repX.pi2 ).equals( repX.pi1.somme( this.negatif ) );
		} catch (ClassCastException e)
		{
			return false;
		}
	}
}



