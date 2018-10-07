package guru.springframework.springbootpetclinic.services.map;

import guru.springframework.springbootpetclinic.model.PetType;
import guru.springframework.springbootpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
}
