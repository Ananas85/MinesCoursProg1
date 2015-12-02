package eval;

public class Test {
    public static void main( String[] args ) {
        /*
		 * Question 2.4 : test de Zero, Succ et Nat
		 */
        FabriqueNats<Nat> fabriqueNats = Zero.SINGLETON;

        Nat zero = fabriqueNats.creer();

        Nat un = fabriqueNats.creer( zero );

        Nat deux = fabriqueNats.creer( un );

        Nat quatre = deux.somme( deux );

        Nat huit = quatre.produit( deux );

        System.out.println( "##### TEST DE LA QUESTION 2.4 -> TEST DES SUCC ET ZERO #####" );
        System.out.println( " 0 ??? " + zero );
        System.out.println( " 1 ??? " + un );
        System.out.println( " 2 ??? " + deux );
        System.out.println( " 4 ??? " + quatre );
        System.out.println( " 8 ??? " + huit );
		/*
		 * Question 3.3 : test de Relatif et Z
		 */

        System.out.println( "##### TEST DE LA QUESTION 3.3 -> TEST DES RELATIFS #####" );
        // 1pt
        FabriqueRelatifs<Z, Nat> fabriqueRelatifs = new Relatif();
        // 1pt
        Z zeroZ = fabriqueRelatifs.creer( zero, zero );
        Z moinsUn = fabriqueRelatifs.creer( un, deux );
        Z moinsDeux = moinsUn.somme( moinsUn );
        Z quatreZ = moinsDeux.produit( moinsDeux );
        System.out.println( " 0 ??? " + zeroZ );
        System.out.println( "-1 ??? " + moinsUn );
        System.out.println( "-2 ??? " + moinsDeux );
        System.out.println( " 4 ??? " + quatreZ );

		/*
		 * Question 3.5 : test de Diagonale<Nat> et Symetrise<Nat>
		 */

        System.out.println( "##### TEST DE LA QUESTION 3.5 -> TEST DES Symetrise #####" );
        // 1pt
        FabriqueRelatifs<Symetrise<Nat>, Nat> fabriqueSymetrise = new Diagonale<Nat>( zero, zero );
        // 1pt
        Symetrise<Nat> zeroS = fabriqueSymetrise.creer( zero, zero );
        Symetrise<Nat> moinsUnS = fabriqueSymetrise.creer( un, deux );
        Symetrise<Nat> moinsDeuxS = moinsUnS.somme( moinsUnS );
        Symetrise<Nat> quatreS = moinsDeuxS.produit( moinsDeuxS );
        System.out.println( " 0 ??? " + zeroS );
        System.out.println( " -1 ??? " + moinsUnS );
        System.out.println( " -2 ??? " + moinsDeuxS );
        System.out.println( " 4 ??? " + quatreS );


    }
}