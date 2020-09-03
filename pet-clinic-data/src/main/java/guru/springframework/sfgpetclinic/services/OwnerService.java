package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.owner;

public interface OwnerService extends CrudService<owner,Long> {

owner findByLastName(String lastName);

}
