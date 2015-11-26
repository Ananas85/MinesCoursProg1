package session3.demo.patrons.heritageMultiple;

import ModType16_dev.session3.demo.patrons.agregationDelegation.AgentCommuniquant;

public interface AgentEncapsulantMessages extends AgentCommuniquant {
	@Override
	default
	public void envoyer( String msg ) {
		this.emettre(msg);
	}
}
