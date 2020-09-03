package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetServices {
    Pet findbyId(long id);
    Pet saveowner(Pet owner);
    Set<Pet> findall();
}
