package guru.springframework.springbootpetclinic.bootstrap;

import guru.springframework.springbootpetclinic.model.*;
import guru.springframework.springbootpetclinic.services.OwnerService;
import guru.springframework.springbootpetclinic.services.PetTypeService;
import guru.springframework.springbootpetclinic.services.SpecialityService;
import guru.springframework.springbootpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private VetService vetService;
    private PetTypeService petTypeService;
    private SpecialityService specialityService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(petTypeService.findAll().size() == 0 )
            loadData();
    }

    private void loadData() {
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        System.out.println("Loaded Pet Types ....");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiologySpeciality = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgerySpeciality = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistrySpeciality = specialityService.save(dentistry);

        System.out.println("Loaded Specialities ....");

        Owner owner1 = new Owner();
        owner1.setFirstName("Ross");
        owner1.setLastName("Taylor");
        owner1.setAddress("123 USA");
        owner1.setCity("Washington");
        owner1.setTelephone("111-222-333-44");
        Pet snowy = new Pet();
        snowy.setName("snowy");
        snowy.setPetType(savedCatPetType);
        snowy.setOwner(owner1);
        snowy.setBirthDate(LocalDate.now());

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Stephen");
        owner2.setLastName("Lee");
        owner2.setAddress("567 USA");
        owner2.setCity("Newyork");
        owner2.setTelephone("555-666-777-88");
        Pet woofy = new Pet();
        woofy.setName("woofy");
        woofy.setPetType(savedDogPetType);
        woofy.setOwner(owner2);
        woofy.setBirthDate(LocalDate.now());

        ownerService.save(owner2);

        System.out.println("Loaded Owners ....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Julia");
        vet1.setLastName("Robert");
        vet1.getSpecialities().add(savedRadiologySpeciality);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Christian");
        vet2.setLastName("Ralph");
        vet2.getSpecialities().add(savedSurgerySpeciality);

        vetService.save(vet2);

        System.out.println("Loaded Vets ....");
    }
}
