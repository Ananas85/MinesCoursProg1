package session1.tp;

public class NatParInt implements Nat {

    /**
     * Entier relatif ou nul
     */
    private int val;

    public NatParInt( int val ) throws IllegalArgumentException {
        if ( val < 0 ) {
            throw new IllegalArgumentException();
        }
        this.val = val;
    }

    @Override
    public int val() {
        return this.val;
    }

    @Override
    public boolean estNul() {
        return (this.val == 0);
    }

    @Override
    public Nat predecesseur() throws UnsupportedOperationException {
        if ( this.val() == 0 )
        {
            throw new UnsupportedOperationException();
        }
        return new NatParInt( this.val() - 1 );
    }

    @Override
    public Nat creerNatAvecValeur( int val ) throws IllegalArgumentException {
        return new NatParInt( val );
    }

    @Override
    public Nat creerZero() {
        return new NatParInt( 0 );
    }

    @Override
    public Nat creerSuccesseur( Nat predecesseur ) {
        return this.creerNatAvecValeur( predecesseur.val() + 1 );
    }

    @Override
    public Nat somme( Nat x ) {
        return this.creerNatAvecValeur( x.val() + this.val );
    }

    @Override
    public Nat produit( Nat x ) {
        return this.creerNatAvecValeur( x.val() * this.val );
    }

    @Override
    public Nat zero() {
        return this.creerZero();
    }

    @Override
    public Nat un() {
        return this.creerNatAvecValeur( 1 );
    }

    @Override
    public String toString() {
        return Integer.toString( this.val );
    }

    @Override
    public boolean equals( Object O ) {
        if ( O instanceof Integer ) {
            return ((( Integer ) O).intValue() == this.val());
        }

        if ( !(O instanceof Nat) ) {
            return false;
        }

        Nat x = ( Nat ) O;
        return this.val() == x.val();
    }
}
