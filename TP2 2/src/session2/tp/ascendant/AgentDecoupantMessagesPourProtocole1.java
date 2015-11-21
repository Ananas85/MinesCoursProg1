package session2.tp.ascendant;

import session2.tp.AgentCommuniquant;

public class AgentDecoupantMessagesPourProtocole1 extends CanalOutProtocole1 implements AgentCommuniquant {

    /**
     * Constructor
     */
    public AgentDecoupantMessagesPourProtocole1() {

    }

    @Override
    public void envoyer( String msg ) {
        int TAILLE = 5;
        StringBuilder m = new StringBuilder( msg );
        int q = msg.length() / TAILLE;
        int r = msg.length() % TAILLE;
        for ( int j = 0; j < q; j++ ) {
            this.emettre( m.substring( j * TAILLE, (j+1) * TAILLE ) );
        }
        this.emettre( m.substring( q * TAILLE, q * TAILLE + r ) );
    }
}
