package master.springframework.springbootpetclinic.services.map;

import master.springframework.springbootpetclinic.model.Pet;
import master.springframework.springbootpetclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

}
