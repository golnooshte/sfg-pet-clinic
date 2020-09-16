package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.visit;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VisitServiceMap extends AbstractMapService<visit,Long> implements VisitService {
    @Override
    public Set<visit> findAll() {
        return super.findAll();
    }

    @Override
    public visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public visit save(visit visit) {
        if (visit.getPet().getOwner().getId() == null || visit.getPet().getOwner() == null ||
                visit.getPet().getId() == null || visit.getPet() == null) {
            throw new RuntimeException("visit has not been found");

        } else {

            return super.save(visit);
        }
    }
    @Override
    public void deleteById(Long id) {
super.deleteById(id);
    }

    @Override
    public void delete(visit object) {
super.delete(object);
    }
}
