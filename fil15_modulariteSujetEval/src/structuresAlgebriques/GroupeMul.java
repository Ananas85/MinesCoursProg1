package structuresAlgebriques;


public interface GroupeMul<T> extends MonoideMul<T> {
    T inverse();
}