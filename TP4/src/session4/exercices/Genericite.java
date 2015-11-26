package session4.exercices;

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
}
