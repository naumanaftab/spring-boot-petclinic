package master.springframework.springbootpetclinic.services.map;

import master.springframework.springbootpetclinic.model.PetType;
import master.springframework.springbootpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
