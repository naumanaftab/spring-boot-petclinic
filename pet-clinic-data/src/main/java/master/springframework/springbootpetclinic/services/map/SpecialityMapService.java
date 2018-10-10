package master.springframework.springbootpetclinic.services.map;

import master.springframework.springbootpetclinic.model.Speciality;
import master.springframework.springbootpetclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {
}
