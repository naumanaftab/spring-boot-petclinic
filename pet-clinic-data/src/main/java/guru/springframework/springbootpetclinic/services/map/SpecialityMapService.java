package guru.springframework.springbootpetclinic.services.map;

import guru.springframework.springbootpetclinic.model.Speciality;
import guru.springframework.springbootpetclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {
}
