package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.vet;
import guru.springframework.sfgpetclinic.services.CrudService;

import java.util.Set;

public class VetServiceMap
        extends AbstractMapService<vet,Long> implements CrudService<vet,Long> {
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
        return super.save(object.getId(), object);
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
