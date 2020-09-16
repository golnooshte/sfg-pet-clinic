package guru.springframework.sfgpetclinic.Repository;

import guru.springframework.sfgpetclinic.model.owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<owner,Long> {
}
