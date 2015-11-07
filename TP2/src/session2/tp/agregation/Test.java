package session2.tp.agregation;

import session2.tp.Agent;
import session2.tp.AgentCommuniquant;

public class Test {
    public static void main( String[] args ) {
        System.out.println("TEST AGREGATION");

        AgentCommuniquant a = new AgentDecoupantMessages( new CanalOutProtocole1() );
        a.envoyer("nul n'est censé ignorer les principes de modularité.");

        Agent b = new AgentDecoupantMessages( new CanalOutProtocole2() );
        b.envoyer("nul n'est censé ignorer les principes de modularité.");

        a = new AgentEncapsulantMessage( new CanalOutProtocole1() );
        a.envoyer("nul n'est censé ignorer les principes de modularité.");

        b = new AgentEncapsulantMessage( new CanalOutProtocole2() );
        b.envoyer("nul n'est censé ignorer les principes de modularité.");
    }
}
