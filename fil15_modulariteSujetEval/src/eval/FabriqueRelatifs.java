package eval;

public interface FabriqueRelatifs<T, N> {
	T creer(N positif, N negatif); // Crée un entier relatif correspondant
	// à la différence positif - négatif
}
