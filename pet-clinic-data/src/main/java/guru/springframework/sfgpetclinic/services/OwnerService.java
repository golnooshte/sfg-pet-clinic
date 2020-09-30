package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.owner;

import java.util.List;

public interface OwnerService extends CrudService<owner,Long> {

owner findByLastName(String lastName);

    List<owner> findAllByLastNameLike(String s);
}
