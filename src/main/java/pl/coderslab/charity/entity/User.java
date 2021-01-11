package pl.coderslab.charity.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private  String name;
    private  String lastName;
    private  String email;
    private  String password;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User(String name, String lastName, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
