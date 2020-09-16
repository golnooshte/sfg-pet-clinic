package guru.springframework.sfgpetclinic.services.SpringDataJPA;

import guru.springframework.sfgpetclinic.Repository.VisitRepository;
import guru.springframework.sfgpetclinic.model.visit;
import guru.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("SpringDataJPA")
public class VisitJPAService implements VisitService {
    private final VisitRepository visitRepository;

    public VisitJPAService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<visit> findAll() {
        Set<visit> visits=new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public visit save(visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
visitRepository.deleteById(aLong);
    }

    @Override
    public void delete(visit object) {
visitRepository.delete(object);
    }
}
