package eval;

public interface FabriqueNats<T> {
	T creer(); // Crée un entier valant zéro

	T creer(T pred); // Crée un entier naturel égal au successeur de pred
}
