package guru.springframework.sfgpetclinic.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @Builder
    public Pet(Long id, String name, PetType petType, owner owner, LocalDate birthday, Set<visit> visits) {
        super(id);
        this.name = name;
        this.petType = petType;
        this.owner = owner;
        this.birthday = birthday;

        if (visits == null || visits.size() > 0 ) {
            this.visits = visits;
        }
    }


    @ManyToOne
    @JoinColumn(name = "type_id")

    private PetType petType;
    @Column(name = "birth_day")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)

    private LocalDate birthday;
    @ManyToOne
    @JoinColumn(name="owner_id")
    private owner owner;
    @Column(name="name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")
    private Set<visit> visits=new HashSet<>();




}
