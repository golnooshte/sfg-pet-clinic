package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetServices;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<owner,Long> implements OwnerService {
    private PetTypeService petTypeService;
    private PetServices petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetServices petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public owner findByLastName(String lastName) {
        return this.findAll()
                .stream().filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst().orElse(null);
    }

    @Override
    public Set<owner> findAll() {
        return super.findAll();
    }

    @Override
    public owner findById(Long id) {
        return super.findById(id);
    }


    @Override
    public owner save(owner object) {




        if (object!=null){
            if(object.getPets()!=null){
                object.getPets().forEach(pet -> {
                            if(pet.getPetType()!=null){
                                if (pet.getPetType().getId()==null){
                                  pet.setPetType(petTypeService.save(pet.getPetType()));
                                }
                            } else{
                                throw  new RuntimeException("pettypr is required");
                            }if(pet.getId()==null){
                                Pet savepet=petService.save(pet);
                                pet.setId(savepet.getId());
                            }
                });
            }        return super.save(object);

        }else {return  null;}

    }

    @Override
    public void deleteById(Long id) {
super.deleteById(id);
    }

    @Override
    public void delete(owner object) {
super.delete(object);
    }

    @Override
    public List<owner> findAllByLastNameLike(String s) {
        List<owner> owners=new ArrayList<>();

        return null;
    }
}
