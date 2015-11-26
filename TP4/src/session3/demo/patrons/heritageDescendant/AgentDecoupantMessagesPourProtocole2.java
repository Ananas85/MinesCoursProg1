package session3.demo.patrons.heritageDescendant;

import ModType16_dev.session3.demo.patrons.agregationDelegation.AgentCommuniquant;

public class AgentDecoupantMessagesPourProtocole2 extends AgentDecoupantMessages implements AgentCommuniquant{

	@Override
	public void emettre(String msg) {
		System.out.println("protocole 2 : " + msg);
	}

}
