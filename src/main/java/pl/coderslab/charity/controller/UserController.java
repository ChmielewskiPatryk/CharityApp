package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.model.UserModel;
import pl.coderslab.charity.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/users")
    public String usersList(Model model) {
        List<User> userList = userService.findAllUsers();
        List<UserModel> userModelList = new ArrayList<>();

        userList.forEach(s -> {
            UserModel userModel = new UserModel();
            userModelList.add(userModel.toUserModel(s));
        });
        model.addAttribute("users", userModelList);
        return "EditUsers";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteById(Long.parseLong(id));
        return "redirect:/users";
    }

    @GetMapping("/editUser")
    public String editUser(HttpServletRequest httpServletRequest, Model model) {
        String id = httpServletRequest.getParameter("id");
        User userToEdit = userService.getUserById(Long.parseLong(id));
        model.addAttribute("user", userToEdit);
        return "EditUserData";

    }

    @PostMapping("/editUser")
    public String editUser(UserModel userModel){
        User userToEdit = userService.getUserById(Long.parseLong(userModel.getId()));
        userToEdit.setName(userModel.getName());
        userToEdit.setLastName(userModel.getLastName());
        userToEdit.setEmail(userToEdit.getEmail());
        userToEdit.setPassword(userModel.getPassword());
        userService.save(userToEdit,userModel.getRole());
        return "redirect:/users";
    }

    @ModelAttribute
    UserModel userModel(){
        return new UserModel();
    }
}
