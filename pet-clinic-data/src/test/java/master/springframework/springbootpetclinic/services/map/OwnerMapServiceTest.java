package master.springframework.springbootpetclinic.services.map;

import master.springframework.springbootpetclinic.model.Owner;
import master.springframework.springbootpetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest extends AbstractMapService {

    private static final long owner_id = 1L;
    private static final String last_name = "david";

    private OwnerService ownerService;

    @BeforeEach
    void setUp() {
        Owner owner = new Owner();
        owner.setId(owner_id);
        owner.setLastName(last_name);
        ownerService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerService.save(owner);
    }

    @Test
    void service_findAll_success() {
        assertEquals(owner_id, ownerService.findAll().size());
    }

    @Test
    void service_findById_success() {
        assertEquals(owner_id, ownerService.findById(owner_id).getId().longValue());
    }

    @Test
    void service_findByLastName_success() {
        assertEquals(owner_id, ownerService.findByLastName(last_name).getId().longValue());
    }

    @Test
    void service_saveExistingId_success() {
        assertEquals(owner_id, ownerService.save(ownerService.findById(owner_id)).getId().longValue());
    }

    @Test
    void service_saveNoId_success() {
        Owner owner = ownerService.save(new Owner());
        assertNotNull(owner.getId());
    }

    @Test
    void service_deleteById_success() {
        ownerService.deleteById(owner_id);
        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void service_delete_success() {
        ownerService.delete(ownerService.findById(owner_id));
        assertEquals(0, ownerService.findAll().size());
    }
}