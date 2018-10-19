package master.springframework.springbootpetclinic.controllers;

import master.springframework.springbootpetclinic.model.Owner;
import master.springframework.springbootpetclinic.services.springdatajpa.OwnerSpringDataJPAService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    private OwnerSpringDataJPAService ownerService;

    @InjectMocks
    private OwnerController ownerController;

    Set<Owner> owners;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {

        owners = new HashSet<>();
        Owner owner1 = new Owner();
        owner1.setId(1L);
        Owner owner2 = new Owner();
        owner2.setId(2L);
        owners.add(owner1);
        owners.add(owner2);

        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void controller_findOwners_success() throws Exception {

        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"));

        verifyZeroInteractions(ownerService);
    }

    @Test
    void controller_findFormReturnMany_success() throws Exception {

        when(ownerService.findByLastNameLike(anyString())).thenReturn(new ArrayList<>(owners));

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attribute("selections", hasSize(2)));

        verify(ownerService, times(1)).findByLastNameLike(anyString());

    }

    @Test
    void controller_findFormReturnOne_success() throws Exception {

        Owner owner = owners.iterator().next();
        List<Owner> returnedSet = new ArrayList<>();
        returnedSet.add(owner);

        when(ownerService.findByLastNameLike(anyString())).thenReturn(returnedSet);

        mockMvc.perform(get("/owners"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/" + owner.getId()));

        verify(ownerService, times(1)).findByLastNameLike(anyString());
    }

    @Test
    void controller_showOwner_success() throws Exception {

        Owner owner = owners.iterator().next();
        when(ownerService.findById(owner.getId())).thenReturn(owner);

        mockMvc.perform(get("/owners/" + owner.getId()))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attribute("owner", owner))
                .andExpect(model().attribute("owner", hasProperty("id", is(owner.getId()))));

    }
}