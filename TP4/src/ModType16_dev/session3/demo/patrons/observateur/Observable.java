package ModType16_dev.session3.demo.patrons.observateur;

public interface Observable<S extends Observable<S, E , C>, E, C extends Observateur<C, E, S>> {
	void ajouterObservateur( C c );
	void notifierObservateurs( E e );
	// Demande d'information en mode pull
	void informerObservateur( C client );
}
