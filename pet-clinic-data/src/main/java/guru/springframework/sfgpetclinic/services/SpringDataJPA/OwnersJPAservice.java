package guru.springframework.sfgpetclinic.services.SpringDataJPA;

import guru.springframework.sfgpetclinic.Repository.OwnerRepository;
import guru.springframework.sfgpetclinic.Repository.PetRepository;
import guru.springframework.sfgpetclinic.Repository.PetTypeRepository;
import guru.springframework.sfgpetclinic.model.owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
@Profile("SpringDataJPA")
public class OwnersJPAservice
        implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnersJPAservice(OwnerRepository ownerRepository, PetRepository petRepository,
                            PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<owner> findAll() {
        Set<owner> ownerSet=new HashSet<>();

                ownerRepository.findAll().iterator().forEachRemaining(ownerSet::add);
                return ownerSet;
    }

    @Override
    public owner findById(Long aLong) {
        Optional<owner> optionalOwner = ownerRepository.findById(aLong);
        if (optionalOwner.isPresent()) {
            return ownerRepository.findById(aLong).get();
        } else {
            return null;
        }
    }
    @Override
    public owner save(owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
ownerRepository.deleteById(aLong);
    }

    @Override
    public void delete(owner object) {
ownerRepository.delete(object);
    }

}
