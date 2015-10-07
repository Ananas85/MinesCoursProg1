package session1.tp;

public class ZeroRec extends Zero {

    @Override
    public Nat creerZero() {
        return new ZeroRec();
    }

    @Override
    public Nat creerSuccesseur( Nat predecesseur ) {
        return new SuccRec( predecesseur );
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
    public boolean equals( Object O ) {
        if ( !(O instanceof Nat) ) {
            return false;
        }
        Nat x = ( Nat ) O;
        return x.estNul();
    }
}
