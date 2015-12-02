package eval;

/*
 * Une classe générique représentant des couples
 */
public final class Couple<T1, T2> {
	public Couple(T1 c1, T2 c2) {
		pi1 = c1;
		pi2 = c2;
	}

	public final T1 pi1;
	public final T2 pi2;
}
