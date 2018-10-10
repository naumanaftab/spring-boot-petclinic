package master.springframework.springbootpetclinic.services.springdatajpa;

import master.springframework.springbootpetclinic.model.BaseEntity;
import master.springframework.springbootpetclinic.services.CrudService;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractSpringDataJPAService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {

    @Override
    public Set<T> findAll() {
        Set<T> safeCopy = new HashSet<>();
        getCrudRepository().findAll().forEach(safeCopy::add);
        return safeCopy;
    }

    @Override
    public T findById(ID id) {
        return getCrudRepository().findById(id).orElse(null);
    }

    @Override
    public T save(T t) {
        return getCrudRepository().save(t);
    }

    @Override
    public void delete(T t) {
        getCrudRepository().delete(t);
    }

    @Override
    public void deleteById(ID id) {
        getCrudRepository().deleteById(id);
    }

    protected abstract CrudRepository<T, ID> getCrudRepository();
}
