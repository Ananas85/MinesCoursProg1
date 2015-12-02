import java.util.*;

/*
 * Les structures algébriques classiques 
 */

interface SemiGroupeAdd<T> {
    T somme( T x );
}

interface MonoideAdd<T> extends SemiGroupeAdd<T> {
    T zero();
}

interface GroupeAdd<T> extends MonoideAdd<T> {
    T oppose();
}

interface SemiGroupeMul<T> {
    T produit( T x );
}

interface MonoideMul<T> extends SemiGroupeMul<T> {
    T un();
}

interface GroupeMul<T> extends MonoideMul<T> {
    T inverse();
}

interface Anneau<T> extends GroupeAdd<T>, SemiGroupeMul<T> {
}

interface AnneauUnitaire<T> extends Anneau<T>, MonoideMul<T> {
}

interface Corps<T> extends AnneauUnitaire<T>, GroupeMul<T> {
}

/*
 * Exercice 1 : module de calculs
 */

class Calculs {
    /*
     * Question 1.1 : soustraction
     */
    public static <T extends GroupeAdd<T>> T soustraction( T x, T y ) {
        return x.somme( y.oppose() );
    }

    /*
     * Question 1.2 : somme généralisée
     */
    public static <T extends MonoideAdd<T>> T sommeNAire( List<T> l ) {
        if ( l.isEmpty() )
            throw new IllegalArgumentException();
        T tete = l.get( 0 );
        if ( !tete.equals( tete.zero() ) )
            throw new IllegalArgumentException();
        T r = tete;
        for ( T e : l ) {
            r = r.somme( e );
        }
        return r;
    }
}

/*
 * Exercice 2 : les entiers naturels
 */

/*
 * Question 2.1 : l'interface Nat
 */

interface FabriqueNats {
    Nat creer(); // Crée un entier valant zéro

    Nat creer( Nat pred ); // Crée un entier naturel égal au successeur de pred
}

interface Nat extends MonoideAdd<Nat>, MonoideMul<Nat>, FabriqueNats {
    boolean estZero(); // Teste à zéro l'entier naturel

    Nat predecesseur(); // Donne le prédécesseur s'il existe

    int val(); // Convertit l'entier naturel en int

    boolean equals( Object o ); // Renvoie false
    // si o n'est pas de type Nat,
    // teste l'égalité des entiers naturels sinon

    String toString(); // Affiche l'entier renvoyé par val
}

/*
 * Questions 2.2 et 2.4 : patrons "Composite" et "Singleton" 
 * Un entier naturel est : 
 * - ou bien zéro (classe ci-dessous), 
 * - ou bien le successeur d'un entier naturel.
 */
enum Zero implements Nat {
    SINGLETON;

    @Override
    public Nat produit( Nat x ) {
        return this;
    }

    @Override
    public Nat somme( Nat x ) {
        return x;
    }

    @Override
    public Nat un() {
        return creer( creer() );
    }

    @Override
    public Nat zero() {
        return this;
    }

    @Override
    public Nat creer() {
        return this;
    }

    @Override
    public Nat creer( Nat pred ) {
        return new Succ( pred );
    }

    @Override
    public boolean estZero() {
        return true;
    }

    @Override
    public Nat predecesseur() {
        throw new UnsupportedOperationException( "Le zero n'a pas de predecesseur" );
    }

    @Override
    public int val() {
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf( this.val() );
    }
}

/*
 * Questions 2.3 et 2.4 : patron "Composite" 
 * Un entier naturel est : 
 * - ou bien zéro, 
 * - ou bien le successeur d'un entier naturel (classe ci-dessous).
 */
class Succ implements Nat {
    protected Nat pred;

    public Succ( Nat pred ) {
        this.pred = pred;
    }

    @Override
    public boolean estZero() {
        return false;
    }

    @Override
    public Nat predecesseur() {
        return this.pred;
    }

    @Override
    public int val() {
        return 1 + this.predecesseur().val();
    }

    @Override
    public boolean equals( Object o ) {
        if ( !(o instanceof Nat) )
            return false;

        Nat x = ( Nat ) o;

        if ( x.estZero() ) {
            return false;
        }

        return predecesseur().equals( x.predecesseur() );
    }

    @Override
    public String toString() {
        return String.valueOf( this.val() );
    }

    @Override
    public Nat creer() {
        return Zero.SINGLETON;
    }

    @Override
    public Nat creer( Nat pred ) {
        return new Succ( pred );
    }

    @Override
    public Nat zero() {
        return this.creer();
    }

    @Override
    public Nat un() {
        return this.creer( this.creer() );
    }

    @Override
    public Nat somme( Nat x ) {
        return creer( this.predecesseur().somme( x ) );
    }

    @Override
    public Nat produit( Nat x ) {
        return x.somme( this.predecesseur().produit( x ) );
    }
}

/*
 * Une classe générique représentant des couples
 */
final class Couple<T1, T2> {
    public Couple( T1 c1, T2 c2 ) {
        pi1 = c1;
        pi2 = c2;
    }

    public final T1 pi1;
    public final T2 pi2;
}

/*
 * Une interface générique permettant de représenter les éléments des structures
 * algébriques avec une structure de données particulières (des couples
 * pratiquement)
 */
interface Representation<Rep> {
    Rep val();
}

/*
 * Exercice 3 : les entiers relatifs
 */

interface FabriqueRelatifs<T, N> {
    T creer( N positif, N negatif ); // Crée un entier relatif correspondant
    // à la différence positif - négatif
}

interface Z extends Representation<Couple<Nat, Nat>>, FabriqueRelatifs<Z, Nat>, AnneauUnitaire<Z> {
    boolean equals( Object o ); // Renvoie false
    // si o n'est pas de type Z,
    // teste l'égalité des entiers relatifs sinon

    String toString(); // Représente l'entier relatif
    // sous la forme d'une différence
}

/*
 * Question 3.2 : la classe d'implémentation
 */
class Relatif implements Z {
    private Nat positif;
    private Nat negatif;

    public Relatif() {
        this( Zero.SINGLETON, Zero.SINGLETON );
    }

    public Relatif( Nat positif, Nat negatif ) {
        this.positif = positif;
        this.negatif = negatif;
    }

    @Override
    public Z creer( Nat positif, Nat negatif ) {
        return new Relatif( positif, negatif );
    }

    @Override
    public Z oppose() {
        return creer( this.negatif, this.positif );
    }

    @Override
    public Z zero() {
        return this.creer( this.positif, this.positif );
    }

    @Override
    public Z un() {
        return new Relatif( this.positif.un(), this.positif.zero() );
    }

    @Override
    public Couple<Nat, Nat> val() {
        return new Couple<Nat, Nat>( this.positif, this.negatif );
    }

    @Override
    public Z somme( Z x ) {
        Couple<Nat, Nat> repX = x.val();
        return this.creer( this.positif.somme( repX.pi1 ), this.negatif.somme( repX.pi2 ) );
    }

    @Override
    public Z produit( Z x ) {
        Couple<Nat, Nat> repX = x.val();
        Nat positif = this.positif.produit( repX.pi1 ).somme( this.negatif.produit( repX.pi2 ) );
        Nat negatif = this.negatif.produit( repX.pi1 ).somme( this.positif.produit( repX.pi2 ) );
        return creer( positif, negatif );
    }

    @Override
    public String toString() {
        return String.valueOf( this.positif.val() - this.negatif.val() );
    }

    @Override
    public boolean equals( Object obj ) {
        if ( !(obj instanceof Z) )
            return false;
        Couple<Nat, Nat> repX = (( Z ) obj).val();
        return this.positif.somme( repX.pi2 ).equals( repX.pi1.somme( this.negatif ) );
    }
}

/*
 * Question 3.4 : généralisation Interface et classe d'implémentation génériques
 * pour la symétrisation
 */
interface Symetrise<T extends MonoideMul<T> & MonoideAdd<T>> extends FabriqueRelatifs<Symetrise<T>, T>, Representation<Couple<T, T>>, AnneauUnitaire<Symetrise<T>> {
    boolean equals( Object o ); // Renvoie false
    // si o n'est pas de type Symetrise<T>,
    // teste l'égalité relatifs sinon

    String toString(); // Représente le relatif
    // sous la forme d'une différence
}


class Diagonale<T extends MonoideAdd<T> & MonoideMul<T>> implements Symetrise<T> {
    private T positif;
    private T negatif;

    public Diagonale( T positif, T negatif ) {
        this.positif = positif;
        this.negatif = negatif;
    }

    @Override
    public Symetrise<T> creer( T positif, T negatif ) {
        return new Diagonale<T>( positif, negatif );
    }

    @Override
    public Symetrise<T> oppose() {
        return new Diagonale<T>( negatif, positif );
    }

    @Override
    public Symetrise<T> zero() {
        return new Diagonale<T>( this.positif.zero(), this.positif.zero() );
    }

    @Override
    public Symetrise<T> un() {
        return new Diagonale<T>( this.positif.un(), this.positif.zero() );
    }

    @Override
    public Couple<T, T> val() {
        return new Couple<T, T>( this.positif, this.negatif );
    }

    @Override
    public Symetrise<T> somme( Symetrise<T> x ) {
        Couple<T, T> repX = x.val();
        return this.creer( this.positif.somme( repX.pi1 ), this.negatif.somme( repX.pi2 ) );
    }

    @Override
    public Symetrise<T> produit( Symetrise<T> x ) {
        Couple<T, T> repX = x.val();
        T positif = this.positif.produit( repX.pi1 ).somme( this.negatif.produit( repX.pi2 ) );
        T negatif = this.negatif.produit( repX.pi1 ).somme( this.positif.produit( repX.pi2 ) );
        return creer( positif, negatif );
    }

    @Override
    public String toString() {
        return String.valueOf( this.positif.toString() + "-" + this.negatif.toString() );
    }

    @Override
    public boolean equals( Object obj ) {
        try {
            @SuppressWarnings("unchecked")
            Symetrise<T> x = ( Symetrise<T> ) obj;
            Couple<T, T> repX = x.val();
            return this.positif.somme( repX.pi2 ).equals( repX.pi1.somme( this.negatif ) );
        } catch ( ClassCastException e ) {
            return false;
        }
    }
}

/*
 * Exercice 4 : les rationnels
 */

/*
 * Question 4.1 : l'interface
 */

interface FabriqueFractions<T, A> {
    T creer( A numerateur, A denominateur ); // Crée le rationnel
    // numerateur/denominateur
}

interface Q extends FabriqueFractions<Q, Z>, Representation<Couple<Z, Z>>, Corps<Q> {
    String toString(); // Représente le rationnel sous la forme
    // "numerateur/denominateur"

    boolean equals( Object o ); // Renvoie false
    // si o n'est pas de type Q,
    // teste l'égalité des rationnels sinon
}

/*
 * Question 4.2 : la classe d'implémentation
 */
class Rationnel implements Q {
    private Z numerateur;
    private Z denominateur;

    public Rationnel( Z numerateur, Z denominateur ) {
        this.numerateur = numerateur;
        this.denominateur = denominateur;
    }

    private Z getNumerateur() {
        return numerateur;
    }

    private Z getDenominateur() {
        return denominateur;
    }

    @Override
    public Q creer( Z numerateur, Z denominateur ) {
        return new Rationnel( numerateur, denominateur );
    }

    @Override
    public Q oppose() {
        return creer( this.numerateur.oppose(), this.denominateur );
    }

    @Override
    public Q inverse() {
        return creer( this.denominateur, this.numerateur );
    }

    @Override
    public Q zero() {
        return this.creer( this.numerateur.zero(), this.numerateur.un() );
    }

    @Override
    public Q un() {
        return this.creer( this.numerateur, this.numerateur );
    }

    @Override
    public Couple<Z, Z> val() {
        return new Couple<Z, Z>( this.numerateur, this.denominateur );
    }

    @Override
    public Q somme( Q x ) {
        Couple<Z, Z> repX = x.val();

        Z num = this.getNumerateur().produit( repX.pi2 ).somme( this.denominateur.produit( repX.pi1 ) );
        Z den = this.getDenominateur().produit( repX.pi2 );
        return this.creer( num, den );
    }

    @Override
    public Q produit( Q x ) {
        Couple<Z, Z> repX = x.val();
        return this.creer( this.numerateur.produit( repX.pi1 ), this.denominateur.produit( repX.pi2 ) );
    }

    public String toString() {
        return "(" + getNumerateur() + ")/(" + getDenominateur() + ")";
    }

    public boolean equals( Object o ) {
        if ( !(o instanceof Q) ) return false;
        Q x = ( Q ) o;
        Z numerateurArg = x.val().pi1;
        Z denominateurArg = x.val().pi2;
        return getNumerateur().produit( denominateurArg ).equals(
                numerateurArg.produit( getDenominateur() ) );
    }
}

/*
 * Question 4.4 : généralisation 
 * Interface et classe d'implémentation génériques
 * pour le corps des fractions
 */
interface Fraction<T extends AnneauUnitaire<T>> extends FabriqueFractions<Fraction<T>, T>, Representation<Couple<T, T>>, Corps<Fraction<T>> {
    String toString(); // Représente le rationnel sous la forme
    // "numerateur/denominateur"

    boolean equals( Object o ); // Renvoie false
    // si o n'est pas de type Fraction<T>,
    // teste l'égalité des rationnels sinon
}

class Rapport<T extends AnneauUnitaire<T>> implements Fraction<T> {
    private T numerateur;
    private T denominateur;

    public Rapport( T numerateur, T denominateur ) {
        this.numerateur = numerateur;
        this.denominateur = denominateur;
    }

    @Override
    public Fraction<T> creer( T numerateur, T denominateur ) {
        return new Rapport<T>( numerateur, denominateur );
    }

    @Override
    public Fraction<T> oppose() {
        return creer( this.numerateur.oppose(), this.denominateur );
    }

    @Override
    public Fraction<T> inverse() {
        return creer( this.denominateur, this.numerateur );
    }

    @Override
    public Fraction<T> zero() {
        return this.creer( this.numerateur.zero(), this.numerateur.un() );
    }

    @Override
    public Fraction<T> un() {
        return this.creer( this.numerateur, this.numerateur );
    }

    @Override
    public Couple<T, T> val() {
        return new Couple<T, T>( this.numerateur, this.denominateur );
    }

    @Override
    public Fraction<T> somme( Fraction<T> x ) {
        Couple<T, T> repX = x.val();

        T num = this.numerateur.produit( repX.pi2 ).somme( this.denominateur.produit( repX.pi1 ) );
        T den = this.denominateur.produit( repX.pi2 );
        return this.creer( num, den );
    }

    @Override
    public Fraction<T> produit( Fraction<T> x ) {
        Couple<T, T> repX = x.val();
        return this.creer( this.numerateur.produit( repX.pi1 ), this.denominateur.produit( repX.pi2 ) );
    }

    public String toString() {
        return "(" + numerateur + ")/(" + denominateur + ")";
    }

    @Override
    public boolean equals( Object obj ) {
        try {
            @SuppressWarnings("unchecked")
            Symetrise<T> x = ( Symetrise<T> ) obj;
            Couple<T, T> repX = x.val();
            return this.numerateur.produit( repX.pi2 ).equals( repX.pi1.produit( this.denominateur ) );
        } catch ( ClassCastException e ) {
            return false;
        }
    }
}

public class Test {
    public static void main( String[] args ) {
        /*
         * Question 2.5 : test de Zero, Succ et Nat
		 */

        FabriqueNats fab = Zero.SINGLETON;
        Nat zero = fab.creer();
        Nat un = fab.creer( zero );
        Nat deux = fab.creer( un );
        Nat quatre = deux.somme( deux );
        Nat huit = deux.produit( quatre );
        System.out.println( "zero :  " + zero );
        System.out.println( "un :    " + un );
        System.out.println( "deux :  " + deux );
        System.out.println( "quatre :" + quatre );
        System.out.println( "huit :  " + huit );

		/*
         * Question 3.3 : test de Relatif et Z
		 */
        FabriqueRelatifs<Z, Nat> fabZ = new Relatif();
        Z zeroZ = fabZ.creer( zero, zero );
        Z moinsUn = fabZ.creer( un, deux );
        Z moinsDeux = fabZ.creer( deux, quatre );
        Z quatreZ = moinsDeux.produit( moinsDeux );
        System.out.println( "z ́ero Z : " + zeroZ );
        System.out.println( "moins un : " + moinsUn );
        System.out.println( "moins deux : " + moinsDeux );
        System.out.println( "quatre Z : " + quatreZ );

		/*
         * Question 3.5 : test de Diagonale<Nat> et Symetrise<Nat>
		 */

        FabriqueRelatifs<Symetrise<Nat>, Nat> fabS = new Diagonale<Nat>( zero, zero );
        Symetrise<Nat> zeroS = fabS.creer( zero, zero );
        Symetrise<Nat> moinsUnS = fabS.creer( un, deux );
        Symetrise<Nat> moinsDeuxS = fabS.creer( deux, quatre );
        Symetrise<Nat> quatreS = moinsDeuxS.produit( moinsDeuxS );
        System.out.println( "zero S: " + zeroS );
        System.out.println( "moins un S: " + moinsUnS );
        System.out.println( "moins deux S: " + moinsDeuxS );
        System.out.println( "quatre S: " + quatreS );

		/*
         * Question 4.3 : test de Rationnel et Q
		 */

        FabriqueFractions<Q, Z> fabQ = new Rationnel( zeroZ, zeroZ );
        Q unDemi = fabQ.creer( moinsUn, moinsDeux );
        Q deuxQ = fabQ.creer( moinsDeux, moinsUn );
        Q unQ = unDemi.somme( unDemi );
        Q unQuart = unDemi.produit( unDemi );
        System.out.println( "un demi : " + unDemi );
        System.out.println( "deux : " + deuxQ );
        System.out.println( "un : " + unQ );
        System.out.println( "un quart : " + unQuart );

		/*
         * Question 4.5 : test de Rapport<Symetrise<Nat>> et
		 * Fraction<Symetrise<Nat>>
		 */

        FabriqueFractions<Fraction<Symetrise<Nat>>, Symetrise<Nat>> fabFS = new Rapport<Symetrise<Nat>>( zeroS, zeroS );
        Fraction<Symetrise<Nat>> unDemiFS = fabFS.creer( moinsUnS, moinsDeuxS );
        Fraction<Symetrise<Nat>> deuxFS = fabFS.creer( moinsDeuxS, moinsUnS );
        Fraction<Symetrise<Nat>> unFS = unDemiFS.somme( unDemiFS );
        Fraction<Symetrise<Nat>> unQuartFS = unDemiFS.produit( unDemiFS );
        System.out.println( "un demi:"+unDemiFS);
        System.out.println("deux:"+deuxFS);
        System.out.println("un:"+unFS);
        System.out.println("un quart:"+unQuartFS);
    }
}
