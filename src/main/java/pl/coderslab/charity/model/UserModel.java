package pl.coderslab.charity.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC,force = true)
@AllArgsConstructor
public class UserModel {
    private  String id;
    @NotNull(message = "Pole nie może być puste")
    private  String name;
    @NotNull(message = "Pole nie może być puste")
    private  String lastName;
    @NotNull(message = "Podaj adres email")
    private  String email;
    private  String role;
    private  String password;


    public UserModel(String name, String lastName, String email, String role, String id) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.role = role;
        this.id = id;
    }

    public UserModel toUserModel(User user){
        Set<Role> userRole = user.getRoles();
        String userRoleAsString="";
        for(Role rol : userRole){
            userRoleAsString =rol.getRole();
        }
        return new UserModel(user.getName(), user.getLastName(), user.getEmail(), userRoleAsString, user.getId().toString());
    }
}
