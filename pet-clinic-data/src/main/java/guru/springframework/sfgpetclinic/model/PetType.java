package guru.springframework.sfgpetclinic.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class PetType extends BaseEntity{
    @Builder
    public PetType(Long id , String name ){
        super(id);
        this.name=name;
    }
    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
