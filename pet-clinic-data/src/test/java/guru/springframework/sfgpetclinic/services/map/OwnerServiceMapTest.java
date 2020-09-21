package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerServiceMapTest {
OwnerServiceMap ownerServiceMap;
Long ownerid=1L;
String Lastname="smith";
    @BeforeEach
    void setUp() {
        ownerServiceMap=new OwnerServiceMap(new PetTypeServiceMap(),new PetServiceMap());
        ownerServiceMap.save(owner.builder().id(ownerid).lastName(Lastname).build());
    }

    @Test
    void findByLastName() {
owner owner=ownerServiceMap.findByLastName(Lastname);
assertEquals("smith",owner.getLastName());
    }

    @Test
    void findAll() {

        Set<owner> owners=ownerServiceMap.findAll();
        assertEquals(1,owners.size());
    }

    @Test
    void findById() {
        Long id =1L;
        owner owner1=ownerServiceMap.findById(id);
        assertEquals(id,owner1.getId());
    }

    @Test
    void save() {
        Long id =2L;
        owner owner1=owner.builder().id(id).build();
                ownerServiceMap.save(owner1);
                assertEquals(id,owner1.getId());
    }

    @Test
    void savewithoutid() {

       owner owner1=ownerServiceMap.save(new owner());
       assertNotNull(owner1);
        assertNotNull(owner1.getId());

    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerid);
        assertEquals(0,ownerServiceMap.findAll().size());

    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerid));
        assertEquals(0,ownerServiceMap.findAll().size());
    }
}