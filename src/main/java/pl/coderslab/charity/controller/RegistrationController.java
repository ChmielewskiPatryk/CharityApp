package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.RegisterForm;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {


    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registrationForm() {
        return "register";
    }

    @PostMapping("/registration")
    public String register(@Valid RegisterForm registerForm, BindingResult bindingResult) {
        boolean userEmail = userService.existsByEmail(registerForm.getEmail());
        if (userEmail) {
            bindingResult.rejectValue("email", "error.user", "Konto o podanym adresie już istnieje");
        }
        if (!registerForm.getPassword().equals(registerForm.getRetypePassword())) {
            bindingResult.rejectValue("retypePassword", "error.user", "Podane hasła nie są identyczne");
        }
        if (bindingResult.hasErrors()) {

            return "register";
        }
        userService.save(registerForm.toUser(), "USER");
        return "registrationSucces";


    }

    @ModelAttribute
    public RegisterForm registerForm() {
        return new RegisterForm();
    }
}
