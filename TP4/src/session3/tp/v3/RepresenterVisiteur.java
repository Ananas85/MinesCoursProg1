package session3.tp.v3;

public class RepresenterVisiteur<E> implements Visiteur<String, E> {

    String resultat;

    public RepresenterVisiteur( String resultat ) {
        this.resultat = resultat;
    }

    @Override
    public String resultat() {
        return this.resultat;
    }

    @Override
    public Visiteur<String, E> visiterVide() {
        return this;
    }

    @Override
    public Visiteur<String, E> visiterCons( MultiEnsemble<E> ens ) {
        E element = ens.element();
        MultiEnsemble<E> reste = ens.reste();
        if ( reste.estVide() ) {
            return new RepresenterVisiteur<>( String.valueOf( element ) );
        }
        return new RepresenterVisiteur<>( element + ", " + reste.accept( this ).resultat() );
    }
}