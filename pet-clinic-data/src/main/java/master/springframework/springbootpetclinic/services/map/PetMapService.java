package master.springframework.springbootpetclinic.services.map;

import master.springframework.springbootpetclinic.model.Pet;
import master.springframework.springbootpetclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

}
