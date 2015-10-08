package session2.heritage.descendant;

import session1.tp.Nat;

public abstract class AlgebreNatParInt implements Nat{

    @Override
    public Nat creerNatAvecValeur( int val ) throws IllegalArgumentException {
        if ( val <  0)
        {
            throw new IllegalArgumentException(  );
        }

        if ( val == 0 )
        {
            return this.creerZero();
        }

        return this.creerSuccesseur( this.creerNatAvecValeur( val - 1 ) );
    }

    @Override
    public Nat creerZero()
    {
        return this.creerNatAvecValeur( 0 );
    }

    @Override
    public Nat creerSuccesseur( Nat predecesseur ) {
        return this.creerNatAvecValeur( predecesseur.val() + 1 );
    }


    @Override
    public Nat somme( Nat x ) {
        return this.creerNatAvecValeur( this.val() + x.val() );
    }

    @Override
    public Nat produit( Nat x ) {
        return this.creerNatAvecValeur( this.val() * x.val() );
    }

    @Override
    public Nat zero() {
        return this.creerNatAvecValeur( 0 );
    }

    @Override
    public Nat un() {
        return this.creerNatAvecValeur( 1 );
    }

    @Override
    public String toString() {
        return Integer.toString( this.val() );
    }

    @Override
    public boolean equals( Object O ) {
        if ( !(O instanceof Nat) ) {
            return false;
        }

        Nat x = ( Nat ) O;
        return this.val() == x.val();
    }


}
