package session1.tp;

public class Test {
    public static void main( String[] args ) {
        System.out.println( "NatParInt" );
        test( new NatParInt( 1 ) );
        System.out.println( "" );

        System.out.println( "Zero" );
        test( new Zero() );
        System.out.println( "" );

        System.out.println( "Succ" );
        test( new Succ( new Zero() ) );
        System.out.println( "" );

        System.out.println( "ZeroRec" );
        test( new ZeroRec() );
        System.out.println( "" );

        System.out.println( "SuccRec" );
        test( new SuccRec( new ZeroRec() ) );
        System.out.println( "" );
    }

    public static void test( FabriqueNat<Nat> fab ) {
        Nat zero = fab.creerZero();
        System.out.println( "0 ? " + zero );
        System.out.println( "true ? " + zero.zero().equals( zero ) );
        Nat un = fab.creerNatAvecValeur( 1 );
        System.out.println( "1 ? " + un );
        System.out.println( "true ? " + un.un().equals( un ) );
        Nat cinq = fab.creerNatAvecValeur( 5 );
        System.out.println( "5 ? " + cinq );
        Nat six = fab.creerNatAvecValeur( 6 );
        System.out.println( "11 ? " + cinq.somme( six ) );
        System.out.println( "30 ? " + cinq.produit( six ) );
    }
}
