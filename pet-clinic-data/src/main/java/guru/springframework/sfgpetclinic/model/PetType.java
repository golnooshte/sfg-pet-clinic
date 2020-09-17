package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder@Entity
public class PetType extends BaseEntity{
    @Column(name = "name")
    private String name;


}
