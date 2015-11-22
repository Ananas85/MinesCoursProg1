package session3.tp.v1;


import java.util.function.Predicate;

/*
 * Ensemble ::= Vide | Cons(Element, Ensemble) | Union(Ensemble, Ensemble)
 */
interface MultiEnsemble<E> {
    // Sélecteurs
    int taille();

    boolean estVide();

    boolean estCons();

    boolean estUnion();

    // Destructeurs
    E element();

    MultiEnsemble<E> reste();

    MultiEnsemble<E> gauche();

    MultiEnsemble<E> droit();

    // Constructeurs
    default MultiEnsemble<E> vide() {
        return Vide.SINGLETON(); // Exemple d'une méthode par défaut
    }

    MultiEnsemble<E> cons( E n );

    MultiEnsemble<E> union( MultiEnsemble<E> ens );

    //Permet de calculer le nombre d'occurrences contenu dans le multi ensemble
    int occurrences( Object e );

    //Permet de filtrer le multi-ensemble en ne retenant que les elements retenu dans le predicat
    MultiEnsemble<E> filtrer( Predicate<E> pred );

    String representer();

    boolean estEgal( MultiEnsemble<?> ens );

    MultiEnsemble<E> supprimerDoublonsIterative();

    MultiEnsemble<E> supprimerDoublonsRecursive();
}


