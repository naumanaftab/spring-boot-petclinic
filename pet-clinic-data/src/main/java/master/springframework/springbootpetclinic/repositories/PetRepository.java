package master.springframework.springbootpetclinic.repositories;

import master.springframework.springbootpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
