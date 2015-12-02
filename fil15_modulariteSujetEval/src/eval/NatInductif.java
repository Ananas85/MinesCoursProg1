package eval;

public interface NatInductif extends Nat {
    @Override
    default public Nat creer()
    {
        return Zero.SINGLETON;
    }

    @Override
    default Nat creer( Nat pred )
    {
        return new Succ(pred);
    }

    @Override
    default Nat zero(){
        return this.creer();
    }

    @Override
    default Nat un(){
        return this.creer( zero() );
    }
}
