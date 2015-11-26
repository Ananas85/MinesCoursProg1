package session3.tp.v3;

class CalculCardinalVisiteur<E> implements Visiteur<Integer, E> {

    private int card;

    public CalculCardinalVisiteur( int card ) {
        this.card = card;
    }

    @Override
    public Integer resultat() {
        return this.card;
    }

    @Override
    public Visiteur<Integer, E> visiterVide() {
        return this;
    }

    @Override
    public Visiteur<Integer, E> visiterCons( MultiEnsemble<E> ens ) {
        int r = (int)ens.reste().accept( this ).resultat();
        return new CalculCardinalVisiteur( r + 1 );
    }
}