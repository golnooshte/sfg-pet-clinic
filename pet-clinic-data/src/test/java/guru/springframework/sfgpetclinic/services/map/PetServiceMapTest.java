package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetServiceMapTest {
    private final Long id=1L;
PetServiceMap petServiceMap;
    @BeforeEach
    void setUp() {
        petServiceMap=new PetServiceMap();
        petServiceMap.save(Pet.builder().id(id).build());
    }

    @Test
    void findAll() {
        Set<Pet> petSet=petServiceMap.findAll();
        assertEquals(1,petSet.size());
     }

    @Test
    void findById() {
        Pet pet=petServiceMap.findById(id);
        assertEquals(id,pet.getId());
    }

    @Test
    void save() {
        Pet savepet=petServiceMap.save(Pet.builder().id(2L).build());
        assertEquals(2,petServiceMap.findAll().size());
    }
    @Test
    void saveDuplicateId() {
        Pet pet= Pet.builder().build();
        pet.setId(1L);
        Pet savedpet=petServiceMap.save(pet);

        assertEquals(1,petServiceMap.findAll().size());
    }

        @Test
    void deleteById() {
        petServiceMap.deleteById(id);
        assertEquals(0,petServiceMap.findAll().size());
    }

    @Test
    void delete() {
        petServiceMap.delete(petServiceMap.findById(id));
        assertEquals(0,petServiceMap.findAll().size());


    }

}