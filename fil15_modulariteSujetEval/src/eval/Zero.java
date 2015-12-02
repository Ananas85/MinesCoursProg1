package eval;

public enum Zero implements NatInductif {
    SINGLETON;

    @Override
    public boolean estZero() {
        return true;
    }

    @Override
    public Nat predecesseur() {
        throw new UnsupportedOperationException( "Zero n'a pas de predecesseur" );
    }

    @Override
    public int val() {
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf( this.val() );
    }

    @Override
    public Nat produit( Nat x ) {
        return this;
    }

    @Override
    public Nat somme( Nat x ) {
        return x;
    }
}
