package ModType16_dev.session1.tp;

public interface FabriqueNaturels<T> {
	T creerNatAvecValeur( int val );
	T creerZero();
	T creerSuccesseur( T predecesseur );
}
