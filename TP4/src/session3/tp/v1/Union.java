package session3.tp.v1;

import java.util.function.Predicate;

class Union implements MultiEnsembleComposite {

    private MultiEnsemble gauche;
    private MultiEnsemble droit;
    private int taille;

    // Mémorisation
    private int element;
    private MultiEnsemble reste;

    public Union(MultiEnsemble g, MultiEnsemble d) {
        this.gauche = g;
        this.droit = d;
        this.taille = g.taille() + d.taille();
    }

    @Override
    public int taille() {
        return this.taille;
    }

    @Override
    public boolean estVide() {
        return (this.taille() == 0);
    }

    @Override
    public boolean estCons() {
        return false;
    }

    @Override
    public boolean estUnion() {
        return true;
    }

    private void decomposer(){
        // Precondition : !this.estVide()
        MultiEnsemble courant = this; // Invariant : !courant.estVide()
        while(true){
            if(courant.estCons()){ // Cons
                this.reste = courant.reste();
                this.element = courant.element();
                return;
            }

            if(courant.gauche().estCons()) {
                this.reste = courant.gauche().reste().union(courant.droit());
                this.element = courant.gauche().element();
                return;
            }

            if(courant.gauche().estVide()){
                courant = courant.droit();
            }else{
                courant = courant.gauche().gauche().union(courant.gauche().droit().union(courant.droit()));
            }
        }
    }

    @Override
    public int element() {
        if(this.estVide()){
            throw new UnsupportedOperationException();
        }
        if(this.reste != null){
            return this.element;
        }
        decomposer();
        return this.element;
    }

    @Override
    public MultiEnsemble reste() {
        if(this.estVide()){
            throw new UnsupportedOperationException();
        }
        if(this.reste != null){
            return this.reste;
        }
        decomposer();
        return this.reste;
    }

    @Override
    public MultiEnsemble gauche() {
        return this.gauche;
    }

    @Override
    public MultiEnsemble droit() {
        return this.droit;
    }

    @Override
    public int occurences( Object e ) {
        return 0;
    }

    @Override
    public MultiEnsemble filtrer( Predicate pred ) {
        return null;
    }

    @Override
    public String representer() {
        return null;
    }

    @Override
    public boolean estEgal( MultiEnsemble ens ) {
        return false;
    }
}