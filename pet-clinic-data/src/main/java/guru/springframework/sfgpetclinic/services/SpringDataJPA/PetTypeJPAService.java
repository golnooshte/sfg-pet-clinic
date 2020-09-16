package guru.springframework.sfgpetclinic.services.SpringDataJPA;

import guru.springframework.sfgpetclinic.Repository.PetTypeRepository;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
@Profile("SpringDataJPA")

public class PetTypeJPAService implements PetTypeService {
    private  final PetTypeRepository petTypeRepository;

    public PetTypeJPAService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes=new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        Optional<PetType> petTypeOptional=petTypeRepository.findById(aLong);
        if(petTypeOptional.isPresent()){
            return petTypeOptional.get();
        }
        else{
            return null;
        }    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
petTypeRepository.deleteById(aLong);
    }

    @Override
    public void delete(PetType object) {
petTypeRepository.delete(object);
    }
}
