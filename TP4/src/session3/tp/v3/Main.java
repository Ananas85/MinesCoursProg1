package session3.tp.v3;

import java.math.BigInteger;

public class Main {
    public static void main( String[] args ) {
        MultiEnsemble<Integer> vide = Vide.SINGLETON();
        System.out.println( "{} ? " + vide.representer() );
        MultiEnsemble<Integer> a = vide.cons( 1 ).cons( 1 ).cons( 2 );
        System.out.println( "{2, 1, 1} ? " + a );
        System.out.println( "false ? " + a.estVide() );
        System.out.println( "true ? " + a.estCons() );
        System.out.println( "false ? " + a.estUnion() );
        System.out.println( "{2, 1, 1, 2, 1, 1} ? " + a.union( a ) );
        System.out.println( "{2, 1, 1} ? " + a.union( vide ) );
        a = vide.cons( 3 ).cons( 4 ).union( a );
        System.out.println( "{4, 3, 2, 1, 1} ? " + a );
        System.out.println( "{4, 3} ? " + a.gauche() );
        System.out.println( "{2, 1, 1} ? " + a.droit() );
        System.out.println( "0 ? " + a.occurrences( 5 ));
        System.out.println( "2 ? " + a.occurrences( 1 ) );
        System.out.println( "true ? " + a.equals( a ) );
        System.out.println( "false ? " + a.equals( a.cons( 5 ) ) );
        System.out.println( "{4, 3, 2, 1} ? " + a.supprimerDoublonsIterative());
        System.out.println( "{4, 3, 2, 1} ? " + a.supprimerDoublonsRecursive());

        MultiEnsemble<Integer> b = vide;
        BigInteger max = BigInteger.valueOf( 100000 );
        for ( int i = 0; i < max.intValue(); i++ ) {
            b = b.union( vide.cons( i ) );
        }
        System.out.println( max + " ? " + b.taille() );
        BigInteger s = BigInteger.ZERO;
        for ( Integer element : b )
        {
            s = s.add( BigInteger.valueOf( element ) );
        }

        System.out.println( max.multiply( max.subtract( BigInteger.ONE ) ).divide( BigInteger.valueOf( 2 ) ) + " ? " + s );

        RepresenterVisiteur r = new RepresenterVisiteur("");
        System.out.println("{4, 3, 2, 1, 1} ? " + "{" + r.visiterCons( a ).resultat() + "}");
        CalculCardinalVisiteur c = new CalculCardinalVisiteur(0);
        System.out.println("5 ? " + c.visiterCons( a ).resultat());
    }
}