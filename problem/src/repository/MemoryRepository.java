package repository;

import domain.Identifiable;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class MemoryRepository<ID, T extends Identifiable<ID>> implements IRepository<ID, T> {
    protected Map<ID, T> elements = new HashMap<>();

    @Override
    public void add(T entity) {
        elements.put(entity.getId(), entity);
    }

    @Override
    public void delete(ID id) {
        elements.remove(id);
    }

    @Override
    public void modify(T entity) {
        elements.put(entity.getId(), entity);
    }

    @Override
    public T findById(ID id) {
        return elements.get(id);
    }

    @Override
    public Collection<T> getAll() {
        return elements.values();
    }
}

