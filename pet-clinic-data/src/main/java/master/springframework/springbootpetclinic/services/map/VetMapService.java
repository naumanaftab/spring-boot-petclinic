package master.springframework.springbootpetclinic.services.map;

import master.springframework.springbootpetclinic.model.Speciality;
import master.springframework.springbootpetclinic.model.Vet;
import master.springframework.springbootpetclinic.services.SpecialityService;
import master.springframework.springbootpetclinic.services.VetService;
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
