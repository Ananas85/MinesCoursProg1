package ModType16_dev.session2.tp.ascendant;

import ModType16_dev.session2.tp.Canal;

public class CanalOutProtocole1 implements Canal {

	@Override
	public void emettre(String msg) {
		System.out.println("protocole 1 : " + msg);
	}

}
