package session2.tp.descendant;

import session2.tp.AgentCommuniquant;

public class AgentEncapsulantMessagesPourProtocole2 extends AgentEncapsulantMessages implements AgentCommuniquant {

    public AgentEncapsulantMessagesPourProtocole2() {
    }

    @Override
    public void emettre( String msg ) {
        System.out.println( "Protocole 2 : " + msg );
    }
}
