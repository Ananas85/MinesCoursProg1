package session.demo1.v2;


public class NatParInt implements Nat {

    private int val;

    public NatParInt(int i)
    {
        if ( i < 0 )
        {
            throw new IllegalArgumentException();
        }
        this.val = i;
    }

    @Override
    public Nat somme( Nat x)
    {
        return new NatParInt(this.getInt() + x.getInt());
    }

    @Override
    public int getInt() {
        return this.val;
    }

    @Override
    public int chiffre(int i) {
        return this.toString().charAt(this.taille() - 1 - i);
    }

    @Override
    public int taille() {
        return this.toString().length();
    }


    @Override
    public String toString()
    {
        return Integer.toString(this.val);
    }
}
