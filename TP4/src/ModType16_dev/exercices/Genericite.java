package ModType16_dev.exercices;


interface SGA<T> {
    T somme(T x);
}

class IntSGA implements SGA<IntSGA> {

    private int val;

    public IntSGA( int val ) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    @Override
    public IntSGA somme( IntSGA x ) {
        return new IntSGA( this.val + x.getVal() );
    }

    public String toString()
    {
        return String.valueOf( this.val );
    }
}

public class Genericite {

    /// n = a + r
    //Acceleratio  logatirthmique au lieur de calculer avec le rand n-1 on travaille ave n/2 a partir de n
    ///
    public static int f( int r, int n, int a ) {
        while ( true ) {
            if ( (n % 2) == 1 ) {
                r += a;
                if ( n == 1 ) return r;
            }
            n /= 2;
            a += a;
        }
    }

    public static <T extends SGA<T>> T f1(T r, int n, T a)
    {
        while ( true ) {
            if ( (n % 2) == 1 ) {
                r = r.somme( a);
                if ( n == 1 ) return r;
            }
            n /= 2;
            a = a.somme( a );
        }
    }

    public static void main( String[] args ) {
        System.out.println( );
        IntSGA zero = new IntSGA(0);
        IntSGA quatre = new IntSGA(4);
        System.out.println("12 ? " + f1( zero, 3, quatre ));
    }
}
