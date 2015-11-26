package session3.tp.v3;

interface Visiteur<T, E> {
    T resultat();

    Visiteur<T, E> visiterVide();

    Visiteur<T, E> visiterCons( MultiEnsemble<E> ens );
}

