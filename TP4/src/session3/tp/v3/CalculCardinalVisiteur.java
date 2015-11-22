package session3.tp.v3;

class CalculCardinalVisiteur implements Visiteur<Integer> {

    private int card;

    public CalculCardinalVisiteur(int card) {
        this.card = card;
    }

    @Override
    public Integer resultat() {
        return this.card;
    }

    @Override
    public Visiteur<Integer> visiterVide() {
        return this;
    }

    @Override
    public Visiteur<Integer> visiterCons(MultiEnsemble ens) {
        int r = (int)ens.reste().accept(this).resultat();
        return new CalculCardinalVisiteur(r + 1);
    }
}