package session2.heritage.descendant;

import session1.tp.Nat;

public class Zero extends AlgebreNatParInt implements Nat {

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
        throw new UnsupportedOperationException(  );
    }


    @Override
    public Nat creerZero() {
        return this;
    }

    @Override
    public Nat creerSuccesseur( Nat predecesseur ) {
        return new Succ( predecesseur );
    }
}
