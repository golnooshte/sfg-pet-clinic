package guru.springframework.sfgpetclinic.model;

import java.util.Set;

public class owner extends person {
    Set<Pet> pets;

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
