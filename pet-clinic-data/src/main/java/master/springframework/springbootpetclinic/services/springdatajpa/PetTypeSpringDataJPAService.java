package master.springframework.springbootpetclinic.services.springdatajpa;

import master.springframework.springbootpetclinic.model.PetType;
import master.springframework.springbootpetclinic.repositories.PetTypeRepository;
import master.springframework.springbootpetclinic.services.PetTypeService;
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
