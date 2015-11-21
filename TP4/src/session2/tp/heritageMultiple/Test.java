package session2.tp.heritageMultiple;

import session2.tp.Agent;
import session2.tp.AgentCommuniquant;

public class Test {
	public static void main(String[] args) {
		AgentCommuniquant a = new AgentDecoupantMessagesPourProtocole1();
		a.envoyer("nul n'est censé ignorer la loi.");
		
		Agent b = new AgentDecoupantMessagesPourProtocole2();
		b.envoyer("nul n'est censé ignorer la loi.");
		
		a = new AgentEncapsulantMessagesPourProtocole1();
		a.envoyer("nul n'est censé ignorer la loi.");
		
		b = new AgentEncapsulantMessagesPourProtocole2();
		b.envoyer("nul n'est censé ignorer la loi.");
	}
}
