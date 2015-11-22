package session3.tp.v3;

public class RepresenterVisiteur implements Visiteur<String> {

    String resultat;

    public RepresenterVisiteur( String resultat ) {
        this.resultat = resultat;
    }

    @Override
    public String resultat() {
        return this.resultat;
    }

    @Override
    public Visiteur<String> visiterVide() {
        return this;
    }

    @Override
    public Visiteur<String> visiterCons( MultiEnsemble ens ) {
        MultiEnsemble reste = ens.reste();
        Object tete = ens.element();
        if ( reste.estVide() ) {
            return new RepresenterVisiteur( String.valueOf( tete ) );
        }
        String r = ( String ) reste.accept( this ).resultat();
        return new RepresenterVisiteur( tete + ", " + r );
    }
}