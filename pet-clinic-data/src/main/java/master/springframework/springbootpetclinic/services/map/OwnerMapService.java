package master.springframework.springbootpetclinic.services.map;

import master.springframework.springbootpetclinic.model.Owner;
import master.springframework.springbootpetclinic.model.Pet;
import master.springframework.springbootpetclinic.services.OwnerService;
import master.springframework.springbootpetclinic.services.PetService;
import master.springframework.springbootpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private PetTypeService petTypeService;
    private PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner save(Owner owner) {
        owner.getPets().forEach(pet -> {
            if(null == pet.getPetType())
                throw new RuntimeException("Pet Type is required");
            if(null == pet.getPetType().getId())
                pet.setPetType(petTypeService.save(pet.getPetType()));
            if(null == pet.getId()) {
                Pet savedPet = petService.save(pet);
                pet.setId(savedPet.getId());
            }
        });
        return super.save(owner);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return map.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getLastName().equals(lastName))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);

    }
}
