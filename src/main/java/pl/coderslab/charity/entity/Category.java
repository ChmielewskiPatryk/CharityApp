package pl.coderslab.charity.entity;

import lombok.*;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table(name ="categories")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private  Long id;
    private final String name;


}
