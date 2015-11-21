package session3.tp.v1;

import java.util.function.Predicate;

class Cons implements MultiEnsembleComposite {

    private int element;
    private MultiEnsemble reste;
    private int taille;

    public Cons(int i, MultiEnsemble ens) {
        this.element = i;
        this.reste = ens;
        this.taille = 1 + ens.taille();
    }

    @Override
    public int taille() {
        return this.taille;
    }

    @Override
    public boolean estVide() {
        return false;
    }

    @Override
    public boolean estCons() {
        return true;
    }

    @Override
    public boolean estUnion() {
        return false;
    }

    @Override
    public int element() {
        return this.element;
    }

    @Override
    public MultiEnsemble reste() {
        return this.reste;
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
    public MultiEnsemble union( MultiEnsemble ens ) {
        return null;
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
