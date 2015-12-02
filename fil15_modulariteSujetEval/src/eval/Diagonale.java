package eval;
/*
 * Question 3.4 : généralisation Interface et classe d'implémentation génériques
 * pour la symétrisation
 */
public class Diagonale<T> 
{
	private T positif;
	private T negatif;

	public Diagonale(T positif, T negatif) {
		this.positif = positif;
		this.negatif = negatif;
	}
}



