package pl.coderslab.charity.dto;

import lombok.Data;
import pl.coderslab.charity.entity.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegisterForm {

    @NotEmpty(message = "Podaj imię")
    @Size(min = 2, max = 30, message = "Imię musi zawierać minimum dwa znaki")
    private String firstName;
    @NotEmpty(message = "Podaj nazwisko")
    @Size(min = 2, max = 30, message = "Nazwisko musi zawierać minimum dwa znaki")
    private String lastName;
    @Email
    @NotEmpty(message="Podaj adres email")
    private String email;
    @NotNull(message = "Hasło nie może być puste")
    @Size(min = 5, max = 30, message = "Hasło musi zawierać minimum 5 znaków")
    private String password;
    @NotNull(message = "Hasło nie może być puste")
    @Size(min = 5, max = 30, message = "Hasło musi zawierać minimum 5 znaków")
    private String retypePassword;


    public User toUser() {
        return new User(firstName,lastName,email,password);
    }
}
