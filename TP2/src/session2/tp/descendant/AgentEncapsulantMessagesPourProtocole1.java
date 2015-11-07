package session2.tp.descendant;

import session2.tp.AgentCommuniquant;

public class AgentEncapsulantMessagesPourProtocole1 extends AgentEncapsulantMessages implements AgentCommuniquant {

    public AgentEncapsulantMessagesPourProtocole1() {
    }

    @Override
    public void emettre( String msg ) {
        System.out.println( "Protocole 1 : " + msg );
    }
}
