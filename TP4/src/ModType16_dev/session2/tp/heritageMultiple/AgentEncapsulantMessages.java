package ModType16_dev.session2.tp.heritageMultiple;

import ModType16_dev.session2.tp.AgentCommuniquant;

public interface AgentEncapsulantMessages extends AgentCommuniquant {
	@Override
	default
	public void envoyer( String msg ) {
		this.emettre(msg);
	}
}
