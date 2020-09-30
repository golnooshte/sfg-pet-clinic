package guru.springframework.sfgpetclinic.Repository;

import guru.springframework.sfgpetclinic.model.owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<owner,Long> {
    owner findByLastName(String lastName);
    List<owner> findAllByLastNameLike(String s);
}
