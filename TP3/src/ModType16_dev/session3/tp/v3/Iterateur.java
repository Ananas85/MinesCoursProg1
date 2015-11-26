package ModType16_dev.session3.tp.v3;

import java.util.Iterator;

class Iterateur<T> implements Iterator<T> {
    private MultiEnsemble<T> reste;
    private T element;

    public Iterateur( MultiEnsemble<T> ens ) {
        decomposer( ens );
    }

    private void decomposer( MultiEnsemble<T> ens ) {
        while ( true ) {

            if ( ens.estVide() ) {
                this.reste = null;
                break;
            }

            if ( ens.estCons() ) {
                this.reste = ens.reste();
                this.element = ens.element();
                break;
            }

            //C'est donc forcement un union

            //Il est constant
            if ( ens.gauche().estCons() ) {
                this.reste = ens.gauche().reste().union( ens.droit() );
                this.element = ens.gauche().element();
                break;
            }

            //Il est vide
            if ( ens.gauche().estVide() ) {
                ens = ens.droit();
                continue;
            }

            //Notre noeud gauche est un union
            ens = ens.gauche().gauche().union( ens.gauche().droit().union( ens.droit() ) );
        }
    }

    public MultiEnsemble<T> reste() {
        if ( reste == null )
            throw new UnsupportedOperationException();
        return this.reste;
    }

    @Override
    public boolean hasNext() {
        return this.reste != null;
    }

    @Override
    public T next() {
        if ( reste == null )
            throw new UnsupportedOperationException();
        T r = this.element;
        decomposer( reste );
        return r;
    }
}