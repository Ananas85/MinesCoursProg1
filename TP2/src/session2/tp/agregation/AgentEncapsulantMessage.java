package session2.tp.agregation;

import session2.tp.AgentCommuniquant;
import session2.tp.Canal;

public class AgentEncapsulantMessage extends AgentDeleguantCanal implements AgentCommuniquant {

    public AgentEncapsulantMessage( Canal canal ) {
        super( canal );
    }

    @Override
    public void envoyer( String msg ) {
        this.emettre( msg );
    }
}
