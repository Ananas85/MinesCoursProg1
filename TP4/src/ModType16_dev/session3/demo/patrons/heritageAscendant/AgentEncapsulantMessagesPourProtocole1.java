package ModType16_dev.session3.demo.patrons.heritageAscendant;

import ModType16_dev.session3.demo.patrons.agregationDelegation.AgentCommuniquant;
import ModType16_dev.session3.demo.patrons.agregationDelegation.CanalOutProtocole1;

public class AgentEncapsulantMessagesPourProtocole1 extends CanalOutProtocole1 implements AgentCommuniquant {

	@Override
	public void envoyer(String msg) {
		this.emettre(msg);
	}
	

}
