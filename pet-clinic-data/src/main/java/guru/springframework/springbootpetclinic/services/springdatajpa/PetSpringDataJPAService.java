package guru.springframework.springbootpetclinic.services.springdatajpa;

import guru.springframework.springbootpetclinic.model.Pet;
import guru.springframework.springbootpetclinic.repositories.PetRepository;
import guru.springframework.springbootpetclinic.services.PetService;
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
