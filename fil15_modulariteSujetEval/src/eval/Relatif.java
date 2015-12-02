package eval;


/*
 * Question 3.2 : la classe implémentant Z
 */

class Relatif implements Z {
    private Nat positif;
    private Nat negatif;

    public Relatif() {
        this.creer( Zero.SINGLETON.zero(), Zero.SINGLETON.zero() );
    }

    @Override
    public boolean equals( Object obj ) {
        if ( !(obj instanceof Z) )
            return false;
        Couple<Nat, Nat> repX = (( Z ) obj).val();
        return this.positif.somme( repX.pi2 ).equals( repX.pi1.somme( this.negatif ) );
    }

    public Relatif( Nat positif, Nat negatif ) {
        this.positif = positif;
        this.negatif = negatif;
    }

    @Override
    public Z creer( Nat positif, Nat negatif ) {
        return new Relatif( positif, negatif );
    }

    @Override
    public Z oppose() {
        return creer( this.negatif, this.positif );
    }

    @Override
    public Z zero() {
        return creer( Zero.SINGLETON.zero(), Zero.SINGLETON.zero() );
    }

    @Override
    public Z un() {
        return this.creer( Zero.SINGLETON.un(), Zero.SINGLETON.zero() );
    }

    @Override
    public Couple<Nat, Nat> val() {
        return new Couple<Nat, Nat>( this.positif, this.negatif );
    }

    @Override
    public Z somme( Z x ) {
        Couple<Nat, Nat> repX = x.val();
        return this.creer( this.positif.somme( repX.pi1 ), this.negatif.somme( repX.pi2 ) );
    }

    @Override
    public Z produit( Z x ) {
        Couple<Nat, Nat> repX = x.val();
        Nat positif = this.positif.produit( repX.pi1 ).somme( this.negatif.produit( repX.pi2 ) );
        Nat negatif = this.negatif.produit( repX.pi1 ).somme( this.positif.produit( repX.pi2 ) );
        return creer( positif, negatif );
    }

    @Override
    public String toString() {
        return String.valueOf( this.positif.val() - this.negatif.val() );
    }
}

