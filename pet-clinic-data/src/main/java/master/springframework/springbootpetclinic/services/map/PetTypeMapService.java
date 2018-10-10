package master.springframework.springbootpetclinic.services.map;

import master.springframework.springbootpetclinic.model.PetType;
import master.springframework.springbootpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
