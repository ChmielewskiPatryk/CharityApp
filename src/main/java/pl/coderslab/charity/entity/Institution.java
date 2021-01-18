package pl.coderslab.charity.entity;


import lombok.*;

import javax.persistence.*;


@Data
@RequiredArgsConstructor
@Table(name = "institutions")
@Entity
public class Institution {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private  Long id;
    private  String name;
    private  String description;

    public Institution(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
