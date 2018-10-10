package master.springframework.springbootpetclinic.services.springdatajpa;

import master.springframework.springbootpetclinic.model.Vet;
import master.springframework.springbootpetclinic.repositories.VetRepository;
import master.springframework.springbootpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VetSpringDataJPAService extends AbstractSpringDataJPAService<Vet, Long> implements VetService {

    private VetRepository vetRepository;

    public VetSpringDataJPAService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    protected VetRepository getCrudRepository() {
        return vetRepository;
    }
}
