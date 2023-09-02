package utils;

import java.util.List;

public interface GenericDAO<T>{
    T findById(int id);
    List<T> findAll();
    void save(T entity);
    void update(T entity);
   // void delete(T entity);
    void delete(int id);

}
