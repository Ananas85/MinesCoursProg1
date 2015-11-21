package session2.tp.heritageMultiple;

import session2.tp.AgentCommuniquant;

public interface AgentEncapsulantMessages extends AgentCommuniquant {
    @Override
    default public void envoyer( String msg ) {
        this.emettre( msg );
    }
}
