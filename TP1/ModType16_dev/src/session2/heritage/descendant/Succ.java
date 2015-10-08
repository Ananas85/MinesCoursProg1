package session2.heritage.descendant;


import session1.tp.Nat;

public class Succ extends AlgebreNatParInt implements Nat {

    protected Nat predecesseur;

    public Succ( Nat predecesseur ) {
        this.predecesseur = predecesseur;
    }

    @Override
    public int val() {
        return 1 + predecesseur.val();
    }

    @Override
    public boolean estNul() {
        return false;
    }

    @Override
    public Nat predecesseur() throws UnsupportedOperationException {
        return this.predecesseur();
    }


    @Override
    public Nat creerZero() {
        return new Zero();
    }

    @Override
    public Nat creerSuccesseur( Nat predecesseur ) {
        return new Succ( predecesseur );
    }
}
