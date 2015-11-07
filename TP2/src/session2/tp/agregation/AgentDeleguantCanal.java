package session2.tp.agregation;

import session2.tp.AgentCommuniquant;
import session2.tp.Canal;

public abstract class AgentDeleguantCanal implements AgentCommuniquant {

    protected Canal canal;

    public AgentDeleguantCanal(Canal canal) {
        this.canal = canal;
    }

    @Override
    public abstract void envoyer( String msg );

    @Override
    public void emettre( String msg ) {
        this.canal.emettre( msg );
    }
}
