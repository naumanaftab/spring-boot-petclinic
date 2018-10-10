package master.springframework.springbootpetclinic.services.springdatajpa;

import master.springframework.springbootpetclinic.model.Pet;
import master.springframework.springbootpetclinic.repositories.PetRepository;
import master.springframework.springbootpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetSpringDataJPAService extends AbstractSpringDataJPAService<Pet, Long> implements PetService {

    private PetRepository petRepository;

    public PetSpringDataJPAService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    protected PetRepository getCrudRepository() {
        return petRepository;
    }
}
