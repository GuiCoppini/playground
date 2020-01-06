package datastructs;

public interface DataStructure<T> {
    boolean insert(T obj);
    boolean delete(T obj);
    boolean exists(T obj);
    void fill(T value);
    int size();
}
