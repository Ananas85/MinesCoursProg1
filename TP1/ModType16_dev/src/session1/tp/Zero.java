package session1.tp;

public class Zero implements Nat {

    public Zero() {
    }

    @Override
    public int val() {
        return 0;
    }

    @Override
    public boolean estNul() {
        return true;
    }

    @Override
    public Nat predecesseur() throws UnsupportedOperationException {
        throw new UnsupportedOperationException(
                "Pas de prédécesseur." );
    }

    @Override
    public Nat creerNatAvecValeur( int val ) throws IllegalArgumentException {
        if ( val < 0 ) {
            throw new IllegalArgumentException();
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
        return x;
    }

    @Override
    public Nat produit( Nat x ) {
        return this.creerZero();
    }

    @Override
    public Nat zero() {
        return this.creerZero();
    }

    @Override
    public Nat un() {
        return this.creerSuccesseur( this.zero() );
    }

    @Override
    public String toString() {
        return "0";
    }

    @Override
    public boolean equals( Object O ) {
        if ( !(O instanceof Nat) ) {
            return false;
        }

        Nat x = ( Nat ) O;
        return x.estNul();
    }
}
