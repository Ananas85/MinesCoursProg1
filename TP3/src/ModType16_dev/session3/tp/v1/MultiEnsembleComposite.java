package ModType16_dev.session3.tp.v1;

import java.util.function.Predicate;

public interface MultiEnsembleComposite<T> extends MultiEnsemble<T> {

    @Override
    default public MultiEnsemble cons( T n ) {
        return new Cons( n, this );
    }

    @Override
    default public MultiEnsemble union( MultiEnsemble ens ) {
        return new Union( this, ens );
    }

    @Override
    default public String representer() {
        String result = "{";
        MultiEnsemble rest = this;
        boolean resteEstVide = rest.estVide();
        while ( !resteEstVide ) {
            result = result.concat( String.valueOf( rest.element() ) );
            rest = rest.reste();
            resteEstVide = rest.estVide();
            if ( !resteEstVide ) {
                result = result.concat( ", " );
            }
        }
        return result.concat( "}" );
    }

    @Override
    default public MultiEnsemble<T> filtrer( Predicate<T> pred ) {
        MultiEnsemble<T> res = Vide.SINGLETON();
        MultiEnsemble<T> current = this;
        while ( !current.estVide() ) {
            T currentElement = current.element();
            if ( pred.test( currentElement ) ) {
                res = res.cons( currentElement );
            }
            current = current.reste();
        }
        return res;
    }

    @Override
    default public int occurrences( Object e ) {
        Predicate<T> isEqualTo = s -> s.equals( e );
        return this.filtrer( isEqualTo ).taille();
    }

    @Override
    default public boolean estEgal( MultiEnsemble<?> ens ) {
        if ( this.taille() != ens.taille() ) {
            return false;
        }
        MultiEnsemble<T> current = this;
        while ( !current.estVide() ) {
            T currentElement = current.element();
            if ( this.occurrences( currentElement ) != ens.occurrences( currentElement ) ) {
                return false;
            }
            current = current.reste();
        }
        return true;
    }

    @Override
    default public MultiEnsemble<T> supprimerDoublonsIterative() {
        MultiEnsemble<T> res = Vide.SINGLETON();
        MultiEnsemble<T> vide = Vide.SINGLETON();

        MultiEnsemble<T> current = this;
        while ( !current.estVide() ) {
            T currentElement = current.element();
            if ( res.occurrences( currentElement ) < 1 ) {
                res = res.union( vide.cons( currentElement ) );
            }
            current = current.reste();
        }

        return res;
    }

    @Override
    default public MultiEnsemble<T> supprimerDoublonsRecursive() {
        if ( this.estVide() ) {
            return Vide.SINGLETON();
        }

        MultiEnsemble<T> tmp = this.reste().supprimerDoublonsRecursive();
        if ( tmp.occurrences( this.element() ) < 1 ) {
            tmp = tmp.cons( this.element() );
        }

        return tmp;
    }

    @Override
    default public T element() {
        throw new UnsupportedOperationException();
    }
}