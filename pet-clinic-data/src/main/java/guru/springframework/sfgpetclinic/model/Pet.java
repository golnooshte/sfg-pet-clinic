package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {
    private PetType petType;
    private LocalDate birthday;
    private owner owner;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
