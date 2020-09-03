package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.owner;

import java.util.Set;

public interface OwnerService {
owner findbyId(long id);
owner saveowner(owner owner);
Set<owner> findall();

}
