package ModType16_dev.session3.demo.patrons.heritageDescendant;

import ModType16_dev.session3.demo.patrons.agregationDelegation.AgentCommuniquant;

public class AgentEncapsulantMessagesPourProtocole1 extends AgentEncapsulantMessages implements AgentCommuniquant {
	@Override
	public void emettre(String msg) {
		System.out.println("protocole 1 : " + msg);
	}
}
