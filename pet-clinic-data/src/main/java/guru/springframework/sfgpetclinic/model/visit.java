package guru.springframework.sfgpetclinic.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visits")
public class visit extends BaseEntity{
    @Column(name="Date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)

    private LocalDate date;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="pet_id")
    private Pet pet;
    @Column(name="description")
    private String description;




}
