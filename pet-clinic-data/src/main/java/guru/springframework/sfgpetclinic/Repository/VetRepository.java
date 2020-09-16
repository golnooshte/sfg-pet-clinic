package guru.springframework.sfgpetclinic.Repository;

import guru.springframework.sfgpetclinic.model.vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository  extends CrudRepository<vet,Long> {
}
