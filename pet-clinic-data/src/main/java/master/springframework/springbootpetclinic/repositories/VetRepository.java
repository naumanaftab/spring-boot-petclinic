package master.springframework.springbootpetclinic.repositories;

import master.springframework.springbootpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
