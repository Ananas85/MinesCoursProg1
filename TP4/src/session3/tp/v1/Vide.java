package session3.tp.v1;

public class Vide<T> implements MultiEnsembleComposite<T> {

    public static <T> MultiEnsemble<T> SINGLETON() {
        return new Vide<T>();
    }

    private Vide() {
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
    public T element() {
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
    public String toString() {
        return this.representer();
    }
}
