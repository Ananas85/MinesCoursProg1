package session2.tp.descendant;

import session2.tp.AgentCommuniquant;

public class AgentEncapsulantMessagesPourProtocole2 extends AgentEncapsulantMessages implements AgentCommuniquant {
	@Override
	public void emettre(String msg) {
		System.out.println("protocole 2 : " + msg);
	}
}
