package guru.springframework.springbootpetclinic.services.map;

import guru.springframework.springbootpetclinic.model.Owner;
import guru.springframework.springbootpetclinic.services.OwnerService;

import java.util.Map;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

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
