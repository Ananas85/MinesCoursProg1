package session2.tp.ascendant;

import session2.tp.AgentCommuniquant;

public class AgentEncapsulantMessagesPourProtocole1 extends CanalOutProtocole1 implements AgentCommuniquant {

	@Override
	public void envoyer(String msg) {
		this.emettre(msg);
	}
	

}
