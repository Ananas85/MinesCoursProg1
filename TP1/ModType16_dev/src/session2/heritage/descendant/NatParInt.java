package session2.heritage.descendant;

import session1.tp.Nat;

public class NatParInt extends AlgebreNatParInt implements Nat {

    protected int val;

    public NatParInt( int val ) {
        if ( val < 0 )
        {
            throw new IllegalArgumentException(  );
        }
        this.val = val;
    }

    @Override
    public int val() {
        return this.val();
    }

    @Override
    public boolean estNul() {
        return this.val() == 0;
    }

    @Override
    public Nat predecesseur() throws UnsupportedOperationException {
        return creerNatAvecValeur( this.val() - 1 );
    }

    @Override
    public Nat creerNatAvecValeur( int val ) throws IllegalArgumentException {
        return new NatParInt( val );
    }

}
