package pl.coderslab.charity.entity;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table(name ="donations")
@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private  Long id;
    private final int quantity;
    @ManyToMany
    private final List<Category> categories;
    @ManyToOne
    @JoinColumn(name = "institution_id")
    private final Institution institution;
    private final String street;
    private final String city;
    private final String zipCode;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private final LocalDate pickUpDate;
    private final LocalTime pickUpTime;
    private final String pickUpComment;

}
