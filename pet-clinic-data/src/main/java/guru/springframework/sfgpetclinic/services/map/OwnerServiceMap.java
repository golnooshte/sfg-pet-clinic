package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.owner;
import guru.springframework.sfgpetclinic.services.OwnerService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<owner,Long> implements OwnerService {
    @Override
    public owner findByLastName(String lastName) {
        return null;
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
        return super.save(object.getId(),object);
    }

    @Override
    public void deleteById(Long id) {
super.deleteById(id);
    }

    @Override
    public void delete(owner object) {
super.delete(object);
    }
}
