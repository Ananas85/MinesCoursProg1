package session1.tp;

public interface FabriqueNat<T> {

    /**
     * Méthode renvoyant un entier
     * naturel de valeur l'argument val
     * si val est positif ou nul,
     * lançant une exception java.lang.IllegalArgumentException sinon
     *
     * @param val int
     * @return T
     */
    public T creerNatAvecValeur( int val ) throws IllegalArgumentException;

    /**
     * Crééer l'entier naturel de valeur null
     *
     * @return T
     */
    public T creerZero();

    /**
     * Méthode renvoyer le successeur
     * de l'argument predecesseur
     *
     * @param predecesseur
     * @return T
     */
    public T creerSuccesseur( T predecesseur );
}
