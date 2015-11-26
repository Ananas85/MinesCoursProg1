package ModType16_dev.session1.mutabilite;

import ModType16_dev.session1.demo1.v2.FabriqueNat;
import ModType16_dev.session1.demo1.v2.Nat;

public class FabriqueNatParInt implements FabriqueNat{

	@Override
	public Nat creerNatAvecValeur(int x) {
		return new NatParInt(x);
	}

	@Override
	public Nat creerNatAvecRepresentation(String repDecimale) {
		return new NatParInt(Integer.parseInt(repDecimale));
	}

}
