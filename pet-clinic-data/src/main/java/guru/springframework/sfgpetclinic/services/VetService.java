package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.vet;

import java.util.Set;

public interface VetService {
    vet findbyId(long id);
    vet saveowner(vet owner);
    Set<vet> findall();
}
