package session.demo1.v1;

public class Test {
    public static void main(String[] args) {

        //NatDecimal
        NatParInt x = new NatParInt(5);
        System.out.println("10 ? " + x.somme(x));
        try
        {
            x = new NatParInt(2_000_000_000);
            System.out.println("2_000_000_000 ? " + x.somme(x));
        }
        catch (Exception e)
        {
            System.out.println("Exception attrapée");
        }

        NatDecimal y = new NatDecimal("5");
        System.out.println("10 ? " + y.somme(y));

        NatDecimal z = new NatDecimal("200000000000000");
        System.out.println("400000000000000 ? " + z.somme(z));

    }
}
