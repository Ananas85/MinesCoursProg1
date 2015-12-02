package eval;

/*
 * Question 3.4 : généralisation Interface et classe d'implémentation génériques
 * pour la symétrisation
 */
public interface Symetrise {
	boolean equals(Object o); // Renvoie false
								// si o n'est pas de type Symetrise<T>,
								// teste l'égalité relatifs sinon

	String toString(); // Représente le relatif
						// sous la forme d'une différence
}