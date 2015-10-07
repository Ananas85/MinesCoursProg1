package session1.tp;

public class Succ implements Nat {

    private Nat predecesseur;

    public Succ( Nat predecesseur ) {
        this.predecesseur = predecesseur;
    }

    @Override
    public int val() {
        return 1 + this.predecesseur.val();
    }

    @Override
    public boolean estNul() {
        return false;
    }

    @Override
    public Nat predecesseur() throws UnsupportedOperationException {
        return this.predecesseur;
    }

    @Override
    public Nat creerNatAvecValeur( int val ) throws IllegalArgumentException {
        if ( val < 0 )
        {
            throw new IllegalArgumentException(  );
        }

        Nat nat = this.creerZero();
        for ( int i = 0; i < val; i++ ) {
             nat = this.creerSuccesseur( nat );
            
        }

        return nat;
    }

    @Override
    public Nat creerZero() {
        return new Zero();
    }

    @Override
    public Nat creerSuccesseur( Nat predecesseur ) {
        return new Succ( predecesseur );
    }

    @Override
    public Nat somme( Nat x ) {
        return this.creerNatAvecValeur( this.val() + x.val() );
    }

    @Override
    public Nat produit( Nat x ) {
        return creerNatAvecValeur( this.val() * x.val() );
    }

    @Override
    public Nat zero() {
        return creerZero();
    }

    @Override
    public Nat un() {
        return this.creerSuccesseur( this.zero() );
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

        if ( x.estNul() ) {
            return false;
        }

        return this.val() == x.val();
    }
}
