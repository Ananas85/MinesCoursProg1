package session3.demo.patrons.observateur;

public class Serveur implements Observable<Serveur, String, Client> {
	private ServeurObservations<Serveur, String, Client> gestionnaire;
	private int compteur;

	public Serveur() {
		super();
		this.gestionnaire = new ServeurObservations<Serveur, String, Client>(this);
		compteur = 0;
	}
	
	public void ajouterObservateur(Client c){
		gestionnaire.ajouterObservateur(c);
	}
	public void notifierObservateurs(String e){
		gestionnaire.notifierObservateurs(e);
	}

	@Override
	public void informerObservateur(Client client) {
		gestionnaire.informerObservateur(client);
	}

	public void mettreAJour(){
		compteur++;
		this.notifierObservateurs("mise à jour " + compteur);
	}
}
