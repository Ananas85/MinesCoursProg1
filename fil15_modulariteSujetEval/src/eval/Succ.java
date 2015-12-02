package eval;

public class Succ implements NatInductif {

    protected Nat pred;

    public Succ( Nat pred ) {
        this.pred = pred;
    }

    @Override
    public Nat predecesseur() {
        return this.pred;
    }

    @Override
    public boolean estZero() {
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf( this.val() );
    }

    @Override
    public Nat somme( Nat x ) {
        return creer(predecesseur().somme( x ));
    }

    @Override
    public Nat produit( Nat x ) {
        return x.somme( predecesseur().produit( x ) );
    }

    @Override
    public int val() {
        return 1 + pred.val();
    }

    @Override
    public boolean equals( Object o ) {
        if( !(o instanceof Nat) )
            return false;

        Nat x = (Nat)o;
        
        if (x.estZero())
        {
            return false;
        }

        return predecesseur().equals( x.predecesseur() );
    }
}
