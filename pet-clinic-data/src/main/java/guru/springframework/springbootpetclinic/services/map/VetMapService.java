package guru.springframework.springbootpetclinic.services.map;

import guru.springframework.springbootpetclinic.model.Vet;
import guru.springframework.springbootpetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

}
