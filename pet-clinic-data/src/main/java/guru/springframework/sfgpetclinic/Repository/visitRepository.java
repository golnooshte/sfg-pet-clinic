package guru.springframework.sfgpetclinic.Repository;

import guru.springframework.sfgpetclinic.model.visit;
import org.springframework.data.repository.CrudRepository;

public interface visitRepository extends CrudRepository<visit,Long> {
}
