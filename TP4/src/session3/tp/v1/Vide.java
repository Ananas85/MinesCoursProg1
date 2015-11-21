package session3.tp.v1;

import java.util.function.Predicate;

public enum Vide implements MultiEnsembleComposite {
    SINGLETON;

    @Override
    public int taille() {
        return 0;
    }

    @Override
    public boolean estVide() {
        return true;
    }

    @Override
    public boolean estCons() {
        return false;
    }

    @Override
    public boolean estUnion() {
        return false;
    }

    @Override
    public int element() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MultiEnsemble reste() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MultiEnsemble gauche() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MultiEnsemble droit() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int occurences( Object e ) {
        return 0;
    }

    @Override
    public MultiEnsemble filtrer( Predicate pred ) {
        return null;
    }

    @Override
    public String representer() {
        return null;
    }

    @Override
    public boolean estEgal( MultiEnsemble ens ) {
        return false;
    }
}
