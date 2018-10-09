package guru.springframework.springbootpetclinic.services.springdatajpa;

import guru.springframework.springbootpetclinic.model.PetType;
import guru.springframework.springbootpetclinic.repositories.PetTypeRepository;
import guru.springframework.springbootpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class PetTypeSpringDataJPAService extends AbstractSpringDataJPAService<PetType, Long> implements PetTypeService {

    private PetTypeRepository petTypeRepository;

    public PetTypeSpringDataJPAService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    protected PetTypeRepository getCrudRepository() {
        return petTypeRepository;
    }
}
