package master.springframework.springbootpetclinic.services.springdatajpa;

import master.springframework.springbootpetclinic.model.Speciality;
import master.springframework.springbootpetclinic.repositories.SpecialityRepository;
import master.springframework.springbootpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class SpecialitySpringDataJPAService extends AbstractSpringDataJPAService<Speciality, Long> implements SpecialityService {

    private SpecialityRepository specialityRepository;

    public SpecialitySpringDataJPAService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    protected SpecialityRepository getCrudRepository() {
        return specialityRepository;
    }
}
