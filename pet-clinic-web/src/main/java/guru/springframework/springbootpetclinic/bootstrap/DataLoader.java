package guru.springframework.springbootpetclinic.bootstrap;

import guru.springframework.springbootpetclinic.model.Owner;
import guru.springframework.springbootpetclinic.model.PetType;
import guru.springframework.springbootpetclinic.model.Vet;
import guru.springframework.springbootpetclinic.services.OwnerService;
import guru.springframework.springbootpetclinic.services.PetTypeService;
import guru.springframework.springbootpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private OwnerService ownerService;
    private VetService vetService;
    private PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");

        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");

        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded Pet Types ....");

        Owner owner1 = new Owner();
        owner1.setFirstName("Nauman");
        owner1.setLastName("Aftab");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Rizwan");
        owner2.setLastName("Rathor");

        ownerService.save(owner2);

        System.out.println("Loaded Owners ....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Techfa");
        vet1.setLastName("Kenzie");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mehwish");
        vet2.setLastName("Aftab");

        vetService.save(vet2);

        System.out.println("Loaded Vets ....");

    }
}
