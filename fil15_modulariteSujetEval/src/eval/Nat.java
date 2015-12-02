package eval;

/*
 * Question 2.1 : l'interface Nat
 */
interface Nat {
	boolean estZero(); // Teste à zéro l'entier naturel

	Nat predecesseur(); // Donne le prédécesseur s'il existe

	int val(); // Convertit l'entier naturel en int

	boolean equals(Object o); // Renvoie false
								// si o n'est pas de type Nat,
								// teste l'égalité des entiers naturels sinon

	String toString(); // Affiche l'entier renvoyé par val
}
