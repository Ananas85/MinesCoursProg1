package session2.tp.agregation;

import session2.tp.Canal;

public class CanalOutProtocole1 implements Canal {

    public CanalOutProtocole1() { }

    @Override
    public void emettre( String msg ) {
        System.out.println( "Protocole 1 : " + msg );
    }
}
