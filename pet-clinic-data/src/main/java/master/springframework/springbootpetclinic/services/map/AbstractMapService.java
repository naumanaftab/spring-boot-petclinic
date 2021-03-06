package master.springframework.springbootpetclinic.services.map;

import master.springframework.springbootpetclinic.model.BaseEntity;
import master.springframework.springbootpetclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {

    Map<Long, T> map = new HashMap<>();

    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    public T findById(ID id) {
        return map.get(id);
    }

    public T save(T t) {
        Long nextId = null == t.getId() ? getNextId() : t.getId();
        t.setId(nextId);
        map.put(nextId, t);
        return t;
    }

    public void deleteById(ID id) {
        map.remove(id);
    }

    public void delete(T t) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(t));
    }

    private Long getNextId() {
        return null == map || map.isEmpty() ? 1L : Collections.max(map.keySet()) + 1;
    }
}
