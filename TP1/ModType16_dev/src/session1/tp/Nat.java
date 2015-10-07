package session1.tp;

import hierarchie.SemiAnneauUnitaire;

public interface Nat extends SemiAnneauUnitaire<Nat>, FabriqueNat<Nat>
{

    /**
     * Retourne l'entier relatif égal à l'entier naturel
     *
     * @return int
     */
    public int val();

    /**
     * Vérifie si l'entier naturel est nul
     *
     * @return boolean
     */
    public boolean estNul();

    /**
     * Renvoie le prédécesseur de l'entier naturel si il est non nul
     * Sinon renvoie une exception
     *
     * @return Nat
     */
    public Nat predecesseur() throws UnsupportedOperationException;

}
