package session2.tp.agregation;

import session2.tp.AgentCommuniquant;
import session2.tp.Canal;

public class AgentEncapsulantMessages extends AgentDeleguantCanal implements AgentCommuniquant {

	public AgentEncapsulantMessages(Canal canal) {
		super(canal);
	}

	@Override
	public void envoyer(String msg) {
		this.emettre(msg);
	}

}
