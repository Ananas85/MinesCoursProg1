package session.demo1.v2;

public class NatDecimal implements Nat {

    private String chiffres;

    public NatDecimal(String rep) {
        this.chiffres = rep;
    }

    @Override
    public Nat somme(Nat x) {
        String rep = "";
        int retenue = 0;

        final int taille = (this.taille() < x.taille()) ? x.taille() : this.taille();

        for (int i = 0; i < taille; i++) {
            int s = this.chiffre(i) + x.chiffre(i) + retenue;

            if (s > 9) {
                retenue = 1;
                s -= 10;
            } else {
                retenue = 0;
            }

            rep = s + rep;
        }

        if (retenue == 1) {
            rep = "1" + rep;
        }
        return new NatDecimal(rep);
    }

    @Override
    public int chiffre(int i)
    {
        if( i >= this.taille())
        {
            return 0;
        }
        return Character.getNumericValue(chiffres.charAt(this.taille() - 1 - i));
    }

    @Override
    public int taille()
    {
        return this.chiffres.length();
    }

    @Override
    public String toString() {
        return this.chiffres;
    }

    @Override
    public int getInt() {
        return Integer.parseInt(this.chiffres);
    }
}
