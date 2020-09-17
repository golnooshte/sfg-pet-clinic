package guru.springframework.sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
    private Set<visit> visits=new HashSet<>();




}
