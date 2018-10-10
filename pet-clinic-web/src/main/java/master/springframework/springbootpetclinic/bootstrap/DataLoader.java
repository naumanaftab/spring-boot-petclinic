package master.springframework.springbootpetclinic.bootstrap;

import master.springframework.springbootpetclinic.model.*;
import master.springframework.springbootpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private VetService vetService;
    private PetTypeService petTypeService;
    private SpecialityService specialityService;
    private VisitService visitService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialityService specialityService,
                      VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
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
        surgery.setDescription("Surgery");
        Speciality savedSurgerySpeciality = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry .setDescription("Dentistry");
        Speciality savedDentistrySpeciality = specialityService.save(dentistry);

        System.out.println("Loaded Specialities ....");

        Pet snowy = new Pet();
        snowy.setName("snowy");
        snowy.setPetType(savedCatPetType);
        snowy.setBirthDate(LocalDate.now());

        Owner owner1 = new Owner();
        owner1.setFirstName("Ross");
        owner1.setLastName("Taylor");
        owner1.setAddress("123 USA");
        owner1.setCity("Washington");
        owner1.setTelephone("111-222-333-44");

        owner1.addPet(snowy);
        ownerService.save(owner1);

        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("sick");
        snowy.addVisit(catVisit);
        visitService.save(catVisit);

        Pet woofy = new Pet();
        woofy.setName("woofy");
        woofy.setPetType(savedDogPetType);
        woofy.setBirthDate(LocalDate.now());

        Owner owner2 = new Owner();
        owner2.setFirstName("Stephen");
        owner2.setLastName("Lee");
        owner2.setAddress("567 USA");
        owner2.setCity("Newyork");
        owner2.setTelephone("555-666-777-88");

        owner2.addPet(woofy);
        ownerService.save(owner2);

        Visit dogVisit = new Visit();
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("regular checkup");
        woofy.addVisit(dogVisit);
        visitService.save(dogVisit);

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
