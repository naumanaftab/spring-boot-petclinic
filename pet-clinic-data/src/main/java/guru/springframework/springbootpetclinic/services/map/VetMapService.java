package guru.springframework.springbootpetclinic.services.map;

import guru.springframework.springbootpetclinic.model.Speciality;
import guru.springframework.springbootpetclinic.model.Vet;
import guru.springframework.springbootpetclinic.services.SpecialityService;
import guru.springframework.springbootpetclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private SpecialityService specialityService;

    public VetMapService(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet vet) {
        vet.getSpecialities().forEach(speciality -> {
            if(null == speciality.getId()){
                Speciality savedSpeciality = specialityService.save(speciality);
                speciality.setId(savedSpeciality.getId());
            }
        });
        return super.save(vet);
    }
}
