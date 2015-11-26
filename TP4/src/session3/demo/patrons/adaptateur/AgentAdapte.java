package session3.demo.patrons.adaptateur;

import ModType16_dev.session3.demo.patrons.agregationDelegation.Agent;

public class AgentAdapte implements NouvelAgent{

	private Agent agent;

	@Override
	public void envoyer(String enTete, String msg) {
		// Adaptation du message
		this.agent.envoyer(enTete + "--" + msg);		
	}

}
