package guru.springframework.sfgpetclinic.Repository;

import guru.springframework.sfgpetclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository  extends CrudRepository<Speciality,Long> {
}
