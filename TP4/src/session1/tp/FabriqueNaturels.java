package session1.tp;

public interface FabriqueNaturels<T> {
	T creerNatAvecValeur( int val );
	T creerZero();
	T creerSuccesseur( T predecesseur );
}
