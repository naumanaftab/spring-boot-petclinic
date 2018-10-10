package master.springframework.springbootpetclinic.services.springdatajpa;

import master.springframework.springbootpetclinic.model.Visit;
import master.springframework.springbootpetclinic.repositories.VisitRepository;
import master.springframework.springbootpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
@Profile("springdatajpa")
public class VisitSpringDataJPAService extends AbstractSpringDataJPAService<Visit, Long> implements VisitService {

    private VisitRepository visitRepository;

    public VisitSpringDataJPAService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    protected CrudRepository<Visit, Long> getCrudRepository() {
        return visitRepository;
    }
}
