package guru.springframework.springbootpetclinic.repositories;

import guru.springframework.springbootpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
