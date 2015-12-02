package eval;

import structuresAlgebriques.GroupeMul;

public class Calculs {

    //Question n1
	public static <T extends GroupeMul<T>> T division(T x, T y)
    {
        return x.produit( y.inverse() );
    }
}
