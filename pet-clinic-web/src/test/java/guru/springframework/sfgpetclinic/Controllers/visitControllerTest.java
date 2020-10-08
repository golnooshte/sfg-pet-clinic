package guru.springframework.sfgpetclinic.Controllers;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.owner;
import guru.springframework.sfgpetclinic.services.PetServices;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.HashSet;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)

class visitControllerTest {
    @Mock
    private VisitService visitService;
    @Mock
    private PetServices petServices;
    @InjectMocks
    private visitController controller;
    MockMvc mvc;

    @BeforeEach
    void setUp() {
        controller=new visitController(visitService,petServices);
        mvc= MockMvcBuilders.standaloneSetup(controller).build();
        Long petId = 1L;
        Long ownerId = 1L;
        when(petServices.findById(anyLong()))
                .thenReturn(
                        Pet.builder()
                                .id(petId)
                                .birthday(LocalDate.of(2018,11,13))
                                .name("Cutie")
                                .visits(new HashSet<>())
                                .owner(owner.builder()
                                        .id(ownerId)
                                        .lastName("Doe")
                                        .firstName("Joe")
                                        .build())
                                .petType(PetType.builder()
                                        .name("Dog").build())
                                .build()
                );
    }





    @Test
    void newVisits() throws Exception {
        mvc.perform(get("/owners/1/pets/1/visits/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdateVisitForm"));
    }

    @Test
    void visitProcess() throws Exception {
        mvc.perform(post("/owners/1/pets/1/visits/new").
                contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("date","2018-11-11")
                .param("description", "Another visit "))
                .andExpect(status().is3xxRedirection()).
                andExpect(view().name("redirect:/owners/1" )).
                andExpect(model().attributeExists("visit"));


    }
}