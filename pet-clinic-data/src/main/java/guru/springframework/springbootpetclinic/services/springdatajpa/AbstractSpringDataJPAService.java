package guru.springframework.springbootpetclinic.services.springdatajpa;

import guru.springframework.springbootpetclinic.model.BaseEntity;
import guru.springframework.springbootpetclinic.services.CrudService;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public abstract class AbstractSpringDataJPAService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {

    @Override
    public Set<T> findAll() {
        return (Set<T>) getCrudRepository().findAll();
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
