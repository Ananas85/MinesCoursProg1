package eval;

import structuresAlgebriques.GroupeMul;
import structuresAlgebriques.MonoideMul;

import java.util.List;

public class Calculs {

    //Question n1
    public static <T extends GroupeMul<T>> T division( T x, T y ) {
        return x.produit( y.inverse() );
    }

    public static <T extends MonoideMul<T>> T produitNaire( List<T> l ) {
        if ( l.isEmpty() ) {
            throw new IllegalArgumentException( "La liste est vide" );
        }

        T tete = l.get( 0 );
        if (tete != tete.un())
        {
            throw new IllegalArgumentException( "La liste est vide" );
        }

        for ( T e : l )
        {
            tete = tete.produit( e );
        }
        return tete;
    }
}
