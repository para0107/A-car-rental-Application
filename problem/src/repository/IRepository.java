package repository;

import domain.Identifiable;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public interface IRepository<ID, T extends Identifiable<ID>> {
    void add(T entity);
    void delete(ID id);
    void modify(T entity);
    T findById(ID id);
    Collection<T> getAll();
}