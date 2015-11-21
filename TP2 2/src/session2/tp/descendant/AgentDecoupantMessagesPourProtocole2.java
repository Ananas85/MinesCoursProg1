package session2.tp.descendant;

import session2.tp.AgentCommuniquant;

public class AgentDecoupantMessagesPourProtocole2 extends AgentDecoupantMessages implements AgentCommuniquant {

    /**
     * Constructor
     */
    public AgentDecoupantMessagesPourProtocole2() {

    }

    @Override
    public void emettre( String msg ) {
        System.out.println( "Protocole 2 : " + msg );
    }
}
