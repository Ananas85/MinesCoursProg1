package session2.tp.ascendant;

import session2.tp.AgentCommuniquant;

public class AgentEncapsulantMessagesPourProtocole2 extends CanalOutProtocole2 implements AgentCommuniquant {

    /**
     * Constructor
     */
    public AgentEncapsulantMessagesPourProtocole2() {

    }

    @Override
    public void envoyer( String msg ) {
        this.emettre( msg );
    }
}
