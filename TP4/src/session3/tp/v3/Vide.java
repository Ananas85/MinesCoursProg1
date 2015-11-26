package session3.tp.v3;

public enum Vide implements MultiEnsembleComposite {

    SINGLETON;

    public static MultiEnsemble SINGLETON()
    {
        return SINGLETON;
    }

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
    public String toString() {
        return this.representer();
    }
}
