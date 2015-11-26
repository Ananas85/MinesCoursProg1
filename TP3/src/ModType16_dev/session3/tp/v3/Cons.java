package ModType16_dev.session3.tp.v3;

class Cons<T> implements MultiEnsembleComposite<T> {

    private T element;
    private MultiEnsemble reste;
    private int taille;

    public Cons( T i, MultiEnsemble ens ) {
        this.element = i;
        this.reste = ens;
        this.taille = 1 + ens.taille();
    }

    @Override
    public int taille() {
        return this.taille;
    }

    @Override
    public T element() {
        return this.element;
    }

    @Override
    public MultiEnsemble<T> reste() {
        return this.reste;
    }

    @Override
    public MultiEnsemble<T> gauche() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MultiEnsemble<T> droit() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return this.representer();
    }
}
