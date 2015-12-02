package eval;

import structuresAlgebriques.AnneauUnitaire;
import structuresAlgebriques.MonoideAdd;
import structuresAlgebriques.MonoideMul;

/*
 * Question 3.4 : généralisation Interface et classe d'implémentation génériques
 * pour la symétrisation
 *
 * Comme Z mais encore plus generique
 */
public interface Symetrise<T extends MonoideMul<T> & MonoideAdd<T>> extends FabriqueRelatifs<Symetrise<T>, T>, Representation<Couple<T, T>>, AnneauUnitaire<Symetrise<T>> {
	boolean equals(Object o); // Renvoie false
								// si o n'est pas de type Symetrise<T>,
								// teste l'égalité relatifs sinon

	String toString(); // Représente le relatif
						// sous la forme d'une différence
}