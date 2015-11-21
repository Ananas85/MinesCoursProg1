package session3.tp.v1;

public interface MultiEnsembleComposite extends MultiEnsemble {

    @Override
    default public MultiEnsemble cons(int n) {
        return new Cons(n, this);
    }

    @Override
    default public MultiEnsemble union(MultiEnsemble ens) {
        return new Union(this, ens);
    }
}
