package data;

import java.util.List;

public interface DAO<T>  {
    T get(int id);
    List<T> getAll();
    boolean insert(T t);
    boolean update(T t);
    boolean delete(T t);
}
