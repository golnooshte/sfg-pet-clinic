package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet {
    private PetType petType;
    private LocalDate birthday;
    private owner owner;

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public guru.springframework.sfgpetclinic.model.owner getOwner() {
        return owner;
    }

    public void setOwner(guru.springframework.sfgpetclinic.model.owner owner) {
        this.owner = owner;
    }
}
