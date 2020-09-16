package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.vet;
import guru.springframework.sfgpetclinic.services.SpecialitiesService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})

public class VetServiceMap
        extends AbstractMapService<vet,Long> implements VetService {
    private SpecialitiesService specialitiesService;


    public VetServiceMap(SpecialitiesService specialitiesServices) {
        this.specialitiesService = specialitiesServices;
    }

    @Override
    public Set<vet> findAll() {
        return super.findAll();
    }

    @Override
    public vet findById(Long id) {
        return super.findById(id);
    }


    @Override
    public vet save(vet object) {
        //it means that object.getspecialist !=null
        if(object.getSpecialities().size()>0){
                object.getSpecialities().forEach(speciality ->
                {
                    if(speciality.getId()==null){
                      Speciality savedSepciality=  specialitiesService.save(speciality);

                      //for being sure that speciality has been saved
                      speciality.setId(savedSepciality.getId());
                    }
                });

            }else{
                throw  new RuntimeException("Especiality can not be null");
            }

        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(vet object) {
        super.delete(object);
    }
}
