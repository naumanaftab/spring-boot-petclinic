package master.springframework.springbootpetclinic.services.springdatajpa;

import master.springframework.springbootpetclinic.model.Owner;
import master.springframework.springbootpetclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSpringDataJPAServiceTest  {

    private static final String OWNER_FIRST_NAME = "Smith";
    private static final String OWNER_LAST_NAME = "Good";
    private static final long OWNER_ID = 1L;
    private Owner returnedOwner;

    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerSpringDataJPAService ownerService;

    @BeforeEach
    void setUp() {
        returnedOwner = new Owner();
        returnedOwner.setId(1L);
        returnedOwner.setFirstName(OWNER_FIRST_NAME);
        returnedOwner.setLastName(OWNER_LAST_NAME);

    }

    @Test
    void service_findByLastName_success() {
        when(ownerRepository.findByLastName(OWNER_LAST_NAME)).thenReturn(returnedOwner);

        Owner found = ownerService.findByLastName(OWNER_LAST_NAME);
        assertEquals(1L, found.getId().longValue(), "id.does.not.match");
        assertEquals(OWNER_LAST_NAME, found.getLastName(), "name.does.not.match");
        verify(ownerRepository, Mockito.times(1)).findByLastName(OWNER_LAST_NAME);
    }

    @Test
    void service_findByLastNameLike_success() {
        when(ownerRepository.findAllByLastNameLike(anyString())).thenReturn(singletonList(returnedOwner));

        List<Owner> foundList = ownerService.findByLastNameLike(OWNER_LAST_NAME);
        assertEquals(1L, foundList.get(0).getId().longValue(), "id.does.not.match");
        assertEquals(OWNER_LAST_NAME, foundList.get(0).getLastName(), "name.does.not.match");
        verify(ownerRepository, Mockito.times(1)).findAllByLastNameLike(anyString());
    }

    @Test
    void service_findAll_success() {
        Set<Owner> returnedOwnerSet = new HashSet<>();
        Owner owner1 = new Owner();
        owner1.setId(OWNER_ID);
        Owner owner2 = new Owner();
        owner2.setId(2L);
        returnedOwnerSet.add(owner1);
        returnedOwnerSet.add(owner2);
        when(ownerRepository.findAll()).thenReturn(returnedOwnerSet);

        Set<Owner> owners = ownerService.findAll();
        assertNotNull(owners, "returned.owner.list.is.null");
        assertEquals(2, owners.size(), "wrong.returned.owner.list.size");
        verify(ownerRepository, Mockito.times(1)).findAll();
    }

    @Test
    void service_findById_success() {
        when(ownerRepository.findById(OWNER_ID)).thenReturn(Optional.of(returnedOwner));

        Owner found = ownerService.findById(OWNER_ID);
        assertEquals(OWNER_ID, found.getId().longValue(), "id.does.not.match");
        assertEquals(OWNER_FIRST_NAME, found.getFirstName(), "name.does.not.match");
        verify(ownerRepository, Mockito.times(1)).findById(OWNER_ID);
    }

    @Test
    void service_findById_notFound_success() {
        when(ownerRepository.findById(OWNER_ID)).thenReturn(Optional.empty());
        Owner found = ownerService.findById(OWNER_ID);
        Assertions.assertNull(found);
        verify(ownerRepository, Mockito.times(1)).findById(OWNER_ID);
    }

    @Test
    void service_save_success() {
        Owner ownerToSave = new Owner();
        ownerToSave.setId(OWNER_ID);
        when(ownerRepository.save(ownerToSave)).thenReturn(returnedOwner);

        Owner savedOwner = ownerService.save(ownerToSave);
        assertEquals(OWNER_ID, savedOwner.getId().longValue(), "id.does.not.match");
        assertEquals(OWNER_FIRST_NAME, savedOwner.getFirstName(), "name.does.not.match");
        verify(ownerRepository, Mockito.times(1)).save(ownerToSave);
    }

    @Test
    void service_delete_success() {
        ownerService.delete(returnedOwner);
        verify(ownerRepository, Mockito.times(1)).delete(returnedOwner);
    }

    @Test
    void service_deleteById_success() {
        ownerService.deleteById(OWNER_ID);
        verify(ownerRepository, times(1)).deleteById(OWNER_ID);
    }
}