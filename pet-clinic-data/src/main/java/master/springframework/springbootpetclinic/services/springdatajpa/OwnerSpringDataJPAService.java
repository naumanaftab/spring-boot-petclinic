package master.springframework.springbootpetclinic.services.springdatajpa;

import master.springframework.springbootpetclinic.model.Owner;
import master.springframework.springbootpetclinic.repositories.OwnerRepository;
import master.springframework.springbootpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Owner> findByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike("%"+lastName+"%");
    }
}
