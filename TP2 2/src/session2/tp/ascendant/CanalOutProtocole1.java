package session2.tp.ascendant;

import session2.tp.Canal;

public class CanalOutProtocole1 implements Canal {

    /**
     * Constructor
     */
    public CanalOutProtocole1() {

    }

    @Override
    public void emettre( String msg ) {
        System.out.println( "Protocole 1 : " + msg );
    }
}
