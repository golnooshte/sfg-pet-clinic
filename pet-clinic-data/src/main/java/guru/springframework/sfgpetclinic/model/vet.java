package guru.springframework.sfgpetclinic.model;

import java.util.Set;

public class vet extends person{
    Set<Speciality> specialities;

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
