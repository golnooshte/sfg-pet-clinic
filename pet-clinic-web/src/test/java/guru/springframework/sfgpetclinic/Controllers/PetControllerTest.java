package guru.springframework.sfgpetclinic.Controllers;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetServices;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class PetControllerTest {
    @Mock
    private PetServices petServices;
    @Mock
    private PetTypeService petTypeService;
    @Mock
    private OwnerService ownerService;
    @InjectMocks
    private PetController controller;
    MockMvc mockMvc;
    Set<PetType> petTypes;
owner owner1;
    @BeforeEach
    void setUp() {
        petTypes = new HashSet<>();
owner1=owner.builder().id(1L).build();
        petTypes.add(PetType.builder().id(1L).name("dog").build());
        petTypes.add(PetType.builder().id(2L).name("cat").build());

        mockMvc= MockMvcBuilders.standaloneSetup(controller).build();

    }

    @Test
    void populatePetTypes() {
    }

    @Test
    void findOwner() {
    }

    @Test
    void initOwnerBinder() {
    }

    @Test
    void createnewpet() {
    }

    @Test
    void newPetProcess() {
    }

    @Test
    void editPet() {
    }

    @Test
    void editPetProcess() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(owner1);
        when(petTypeService.findAll()).thenReturn(petTypes);
mockMvc.perform(post("/owners/1/pets/1/edit"))
        .andExpect(status().is3xxRedirection())
        .andExpect(view().name("redirect:/owners/1"));
verify(petServices).save(any());
    }
}