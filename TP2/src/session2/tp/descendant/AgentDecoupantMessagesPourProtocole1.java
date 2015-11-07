package session2.tp.descendant;


import session2.tp.AgentCommuniquant;

public class AgentDecoupantMessagesPourProtocole1 extends AgentDecoupantMessages  implements AgentCommuniquant {

    /**
     * Constructor
     */
    public AgentDecoupantMessagesPourProtocole1() {

    }

    @Override
    public void emettre( String msg ) {
        System.out.println( "Protocole 1 : " + msg );
    }
}
