package master.springframework.springbootpetclinic.services.map;

import master.springframework.springbootpetclinic.model.Visit;
import master.springframework.springbootpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
}
