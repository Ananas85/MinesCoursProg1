package session2.tp.ascendant;

import session2.tp.Agent;
import session2.tp.AgentCommuniquant;

public class Test {
    public static void main( String[] args ) {
        System.out.println("TEST ASCENDANT");

        AgentCommuniquant a = new AgentDecoupantMessagesPourProtocole1();
        a.envoyer("nul n'est censé ignorer les principes de modularité.");

        Agent b = new AgentDecoupantMessagesPourProtocole2();
        b.envoyer("nul n'est censé ignorer les principes de modularité.");

        a = new AgentEncapsulantMessagesPourProtocole1();
        a.envoyer("nul n'est censé ignorer les principes de modularité.");

        b = new AgentEncapsulantMessagesPourProtocole2();
        b.envoyer("nul n'est censé ignorer les principes de modularité.");
    }
}
