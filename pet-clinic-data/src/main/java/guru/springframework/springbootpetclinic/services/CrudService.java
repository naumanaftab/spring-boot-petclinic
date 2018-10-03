package guru.springframework.springbootpetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    void save(T t);

    void delete(T t);

    void deleteById(ID id);
}
