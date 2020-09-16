package guru.springframework.sfgpetclinic.Repository;

import guru.springframework.sfgpetclinic.model.visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<visit,Long> {
}
