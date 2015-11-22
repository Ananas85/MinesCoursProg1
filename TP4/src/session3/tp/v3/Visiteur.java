package session3.tp.v3;

interface Visiteur<T>{
    T resultat();
    Visiteur<T> visiterVide();
    Visiteur<T> visiterCons( MultiEnsemble ens );
}

