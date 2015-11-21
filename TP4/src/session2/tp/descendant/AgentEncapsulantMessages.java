package session2.tp.descendant;

import session2.tp.AgentCommuniquant;

public abstract class AgentEncapsulantMessages implements AgentCommuniquant{
	@Override
	public void envoyer(String msg) {
		this.emettre(msg);
	}
}
