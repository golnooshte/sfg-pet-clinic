package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "type_id")

    private PetType petType;
    @Column(name = "birth_day")
    private LocalDate birthday;
    @ManyToOne
    @JoinColumn(name="owner_id")
    private owner owner;
    @Column(name="name")
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
