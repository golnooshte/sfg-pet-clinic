package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.Repository.OwnerRepository;
import guru.springframework.sfgpetclinic.Repository.PetRepository;
import guru.springframework.sfgpetclinic.Repository.PetTypeRepository;
import guru.springframework.sfgpetclinic.model.owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnersJPAserviceTest {
@Mock
    OwnerRepository ownerRepository;
@Mock
   PetRepository petRepository;
@Mock
   PetTypeRepository petTypeRepository;
@InjectMocks
OwnersJPAservice service;
owner returnowner;
    private String lastName="Smith";

    @BeforeEach
    void setUp() {
        returnowner=owner.builder().id(1L).lastName(lastName).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnowner);
        owner owner1=service.findByLastName(lastName);
         assertEquals("Smith",owner1.getLastName());
         verify(ownerRepository).findByLastName(any());

    }

    @Test
    void findAll() {
        Set<owner> owners=new HashSet<>();
        owners.add(owner.builder().id(2L).build());
        owners.add(owner.builder().id(3L).build());
        when(ownerRepository.findAll()).thenReturn(owners);
        assertEquals(2,service.findAll().size());
        verify(ownerRepository).findAll();
    }

    @Test
    void findById() {
when(ownerRepository.findById(any())).thenReturn(Optional.of(returnowner));
owner owner1=service.findById(returnowner.getId());
assertNotNull(owner1);

    }

    @Test
    void findbyidemprty() {
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());
        owner owner1=service.findById(returnowner.getId());
        assertNull(owner1);
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(returnowner);
        owner owner1=service.save(owner.builder().id(1L).build());

assertNotNull(owner1);
        verify(ownerRepository).save(any());

    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        assertEquals(0,service.findAll().size());
        verify(ownerRepository).deleteById(returnowner.getId());
    }

    @Test
    void delete() {
service.delete(returnowner);
verify(ownerRepository,times(1)).delete(returnowner);
    }
}