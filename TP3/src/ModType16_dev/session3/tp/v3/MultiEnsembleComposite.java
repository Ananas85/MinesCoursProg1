package ModType16_dev.session3.tp.v3;

import java.util.Iterator;
import java.util.function.Predicate;

public interface MultiEnsembleComposite<T> extends MultiEnsemble<T> {

    @Override
    default public MultiEnsemble<T> cons( T n ) {
        return new Cons( n, this );
    }

    @Override
    default public MultiEnsemble<T> union( MultiEnsemble ens ) {
        return new Union( this, ens );
    }

    @Override
    default public boolean estVide()
    {
        return (this.taille() == 0);
    }

    @Override
    default public boolean estCons()
    {
        return (this instanceof Cons);
    }

    @Override
    default public boolean estUnion()
    {
        return (this instanceof Union);
    }

    @Override
    default public String representer() {
        String result = "{";
        int i = 0;
        for ( T currentElement : this ) {
            result = result.concat( String.valueOf( currentElement ) );
            if ( i != this.taille() - 1 ) {
                result = result.concat( ", " );
            }
            i++;
        }

        return result.concat( "}" );
    }

    @Override
    default public MultiEnsemble<T> filtrer( Predicate<T> pred ) {
        MultiEnsemble<T> res = Vide.SINGLETON();

        for ( T currentElement : this ) {
            if ( pred.test( currentElement ) ) {
                res = res.cons( currentElement );
            }
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

        for ( T currentElement : this ) {
            if ( this.occurrences( currentElement ) != ens.occurrences( currentElement ) ) {
                return false;
            }
        }

        return true;
    }

    @Override
    default public MultiEnsemble<T> supprimerDoublonsIterative() {
        MultiEnsemble<T> tmp = Vide.SINGLETON();

        for ( T currentElement : this ) {
            if ( tmp.occurrences( currentElement ) < 1 ) {
                tmp = tmp.cons( currentElement );
            }
        }

        MultiEnsemble<T> res = Vide.SINGLETON();
        for ( T currentElement : tmp ) {
            res = res.cons( currentElement );
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
    default public Iterator<T> iterator() {
        return new Iterateur<T>( this );
    }

    @Override
    default Visiteur accept( Visiteur v ) {
        if ( this.estVide() ) {
            return v.visiterVide();
        }
        return v.visiterCons( this );
    }

    @Override
    default public T element() {
        throw new UnsupportedOperationException();
    }
}