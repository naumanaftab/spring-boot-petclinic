package master.springframework.springbootpetclinic.repositories;

import master.springframework.springbootpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
