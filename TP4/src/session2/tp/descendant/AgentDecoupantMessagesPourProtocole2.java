package session2.tp.descendant;

import session2.tp.AgentCommuniquant;

public class AgentDecoupantMessagesPourProtocole2 extends AgentDecoupantMessages implements AgentCommuniquant{

	@Override
	public void emettre(String msg) {
		System.out.println("protocole 2 : " + msg);
	}

}
