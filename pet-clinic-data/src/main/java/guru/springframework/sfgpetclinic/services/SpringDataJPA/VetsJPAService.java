package guru.springframework.sfgpetclinic.services.SpringDataJPA;

import guru.springframework.sfgpetclinic.Repository.VetRepository;
import guru.springframework.sfgpetclinic.model.vet;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
public class VetsJPAService  implements VetService {
    private final VetRepository vetRepository;

    public VetsJPAService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<vet> findAll() {
        Set<vet> vets=new HashSet<>();
         vetRepository.findAll().iterator().forEachRemaining(vets::add);
         return vets;
    }

    @Override
    public vet findById(Long aLong) {
        Optional<vet> vetOptional=vetRepository.findById(aLong);
        if(vetOptional.isPresent()){
            return vetOptional.get();
        }
        else{
        return null;
    }}

    @Override
    public vet save(vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
vetRepository.deleteById(aLong);
    }

    @Override
    public void delete(vet object) {
vetRepository.delete(object);
    }
}
