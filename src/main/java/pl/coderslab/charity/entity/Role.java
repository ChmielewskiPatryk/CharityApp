package pl.coderslab.charity.entity;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    @Setter(AccessLevel.NONE)
    private Long id;
    private String role;
}
