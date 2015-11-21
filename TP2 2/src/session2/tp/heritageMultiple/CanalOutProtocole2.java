package session2.tp.heritageMultiple;

import session2.tp.Canal;

public class CanalOutProtocole2 implements Canal {

    public CanalOutProtocole2() {
    }

    @Override
    public void emettre( String msg ) {
        System.out.println( "Protocole 2 : " + msg );
    }
}
