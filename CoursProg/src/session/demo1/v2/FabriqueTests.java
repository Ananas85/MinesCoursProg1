package session.demo1.v2;

public class FabriqueTests {
    public static void main(String[] args) {
        FabriqueNatDecimal fabriqueNatDecimal = new FabriqueNatDecimal();
        testerCourt(fabriqueNatDecimal);
        testerGrand(fabriqueNatDecimal);
        FabriqueNatParInt fabriqueNatParInt = new FabriqueNatParInt();
        testerCourt(fabriqueNatParInt);
        testerGrand(fabriqueNatParInt);
        testerInteroperabilite(fabriqueNatDecimal, fabriqueNatParInt);
    }

    public static void testerCourt(FabriqueNat fab)
    {
        Nat x = fab.creerNatAvecValeur(100);
        System.out.println("200 ? " + x.somme(x));
        x = fab.creerNatAvecRepresentation("100");
        System.out.println("200 ? " + x.somme(x));
    }

    public static void testerGrand(FabriqueNat fab)
    {
        try
        {
            Nat x = fab.creerNatAvecValeur(2_000_000_000);
            System.out.println("4_000_000_000 ? " + x.somme(x));
        }
        catch (Exception e)
        {
            System.out.println("Ya un bleme");
        }


        try
        {
            Nat y = fab.creerNatAvecRepresentation("2000000000");
            System.out.println("4_000_000_000 ? " + y.somme(y));
        }
        catch (Exception e)
        {
            System.out.println("Encore un probleme");
        }
    }

    public static void testerInteroperabilite(FabriqueNat fab1, FabriqueNat fab2)
    {
        Nat x = fab1.creerNatAvecValeur(100);
        Nat y = fab2.creerNatAvecRepresentation("100");
        System.out.println("200 ? " + x.somme(x));
        System.out.println("200 ? " + y.somme(y));

    }
}
