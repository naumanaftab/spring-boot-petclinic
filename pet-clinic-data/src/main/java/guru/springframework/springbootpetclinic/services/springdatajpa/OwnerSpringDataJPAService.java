package guru.springframework.springbootpetclinic.services.springdatajpa;

import guru.springframework.springbootpetclinic.model.Owner;
import guru.springframework.springbootpetclinic.repositories.OwnerRepository;
import guru.springframework.springbootpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class OwnerSpringDataJPAService extends AbstractSpringDataJPAService<Owner, Long> implements OwnerService {

    private OwnerRepository ownerRepository;

    public OwnerSpringDataJPAService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return getCrudRepository().findByLastName(lastName);
    }

    @Override
    protected OwnerRepository getCrudRepository() {
        return ownerRepository;
    }
}