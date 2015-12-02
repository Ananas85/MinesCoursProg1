package structuresAlgebriques;


public interface GroupeAdd<T> extends MonoideAdd<T> {
    T oppose();
}