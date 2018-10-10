package master.springframework.springbootpetclinic.services.map;

import master.springframework.springbootpetclinic.model.Visit;
import master.springframework.springbootpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
}
