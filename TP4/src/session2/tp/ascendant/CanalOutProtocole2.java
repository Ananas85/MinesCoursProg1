package session2.tp.ascendant;

import session2.tp.Canal;

public class CanalOutProtocole2 implements Canal {

	@Override
	public void emettre(String msg) {
		System.out.println("protocole 2 : " + msg);
	}

}
