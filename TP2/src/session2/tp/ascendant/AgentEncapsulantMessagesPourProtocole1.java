package session2.tp.ascendant;

import session2.tp.AgentCommuniquant;

public class AgentEncapsulantMessagesPourProtocole1 extends CanalOutProtocole2 implements AgentCommuniquant {

    public AgentEncapsulantMessagesPourProtocole1() {
    }

    @Override
    public void envoyer( String msg ) {
        this.emettre( msg );
    }
}
