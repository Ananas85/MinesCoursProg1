package ModType16_dev.session2.demo.agregationDelegation;

public interface EtatNaturel<T> {
	int val();

	boolean estNul();

	T predecesseur();
}
