package session1.tp;

public class SuccRec extends Succ {

    public SuccRec( Nat predecesseur ) {
        super( predecesseur );
    }

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
        return this.creerSuccesseur( this.predecesseur().somme( x ) );
    }

    @Override
    public Nat produit( Nat x ) {
        return this.predecesseur().produit( x ).somme( x );
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

        return this.predecesseur().equals( x.predecesseur() );
    }
}
