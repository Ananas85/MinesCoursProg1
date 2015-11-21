package session2.exercices;

/*
 * I ::= A | B
 * Lire : "Un I est soit un A, soit un B".
 */

// Patron composite
interface I {
	default void accepter( V visiteur ){
		// L'instruction suivante est-elle correcte ?
		// Peut-on résoudre le nom "parcourir" ? 
		// visiteur.parcourir(this);
	}
}

class A implements I {
	@Override
	public void accepter(V visiteur) {
		visiteur.parcourir(this);
	}
}

class B implements I {
	@Override
	public void accepter(V visiteur) {
		visiteur.parcourir(this);
	}
}

// Visiteur
interface V {
	// Surcharge
	void parcourir( A a );
	void parcourir( B b );
}


public class VisiteurSurcharge {

}
