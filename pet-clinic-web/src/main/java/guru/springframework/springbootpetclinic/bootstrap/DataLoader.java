package guru.springframework.springbootpetclinic.bootstrap;

import guru.springframework.springbootpetclinic.model.Owner;
import guru.springframework.springbootpetclinic.model.Vet;
import guru.springframework.springbootpetclinic.services.OwnerService;
import guru.springframework.springbootpetclinic.services.VetService;
import guru.springframework.springbootpetclinic.services.map.OwnerMapService;
import guru.springframework.springbootpetclinic.services.map.VetMapService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerMapService();
        vetService = new VetMapService();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Nauman");
        owner1.setLastName("Aftab");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Rizwan");
        owner2.setLastName("Rathor");

        ownerService.save(owner2);

        System.out.println("Loaded Owners ....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Techfa");
        vet1.setLastName("Kenzie");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Mehwish");
        vet2.setLastName("Aftab");

        vetService.save(vet2);

        System.out.println("Loaded Vets ....");

    }
}
