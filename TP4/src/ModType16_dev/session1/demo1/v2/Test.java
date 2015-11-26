package ModType16_dev.session1.demo1.v2;

public class Test {

	public static void main(String[] args) {
		Nat x = new NatDecimal("75");
		System.out.println("150 ? " + x.somme(x));
		
		x = new NatDecimal("2000000000");
		System.out.println("4000000000 ? " + x.somme(x));
		
		x = new NatParInt(85);
		System.out.println("170 ? " + x.somme(x));
		
		Nat y = new NatDecimal("45");
		System.out.println("130 ? " + x.somme(y));
		
		y = new NatDecimal("55");
		System.out.println("140 ? " + y.somme(x));
		
		x = new NatParInt(2_000_000_000);
		System.out.println("4_000_000_000 ? " + x.somme(x));
		
	}

}
