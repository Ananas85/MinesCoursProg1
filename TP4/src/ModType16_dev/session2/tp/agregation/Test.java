package ModType16_dev.session2.tp.agregation;

import ModType16_dev.session2.tp.Agent;
import ModType16_dev.session2.tp.AgentCommuniquant;
import ModType16_dev.session2.tp.ascendant.CanalOutProtocole1;
import ModType16_dev.session2.tp.ascendant.CanalOutProtocole2;

public class Test {
	public static void main(String[] args) {
		AgentCommuniquant a = new AgentDecoupantMessages(new CanalOutProtocole1());
		a.envoyer("nul n'est censé ignorer la loi.");
		
		Agent b = new AgentDecoupantMessages(new CanalOutProtocole2());
		b.envoyer("nul n'est censé ignorer la loi.");
		
		a = new AgentEncapsulantMessages(new CanalOutProtocole1());
		a.envoyer("nul n'est censé ignorer la loi.");
		
		b = new AgentEncapsulantMessages(new CanalOutProtocole2());
		b.envoyer("nul n'est censé ignorer la loi.");
	}
}
