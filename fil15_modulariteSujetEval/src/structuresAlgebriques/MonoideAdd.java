package structuresAlgebriques;

public interface MonoideAdd<T> extends SemiGroupeAdd<T> {
    T zero();
}