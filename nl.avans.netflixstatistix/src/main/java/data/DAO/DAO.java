package main.java.data.DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    T get(int id) throws SQLException;
    List<T> getAll() throws SQLException;
    int insert(T t) throws SQLException;
    boolean update(T t);
    boolean delete(T t);
}
