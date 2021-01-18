package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.dto.RegisterForm;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.model.UserModel;
import pl.coderslab.charity.service.RoleService;
import pl.coderslab.charity.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;

    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String getAdminPage() {

        return "indexAdmin";
    }

    @GetMapping("/admins")
    public String getAdmins(Model model) {

        List<User> admin = userService.getUserWithSpecificRole("ADMIN");
        List<UserModel> adminList = new ArrayList<>();
        admin.forEach(s -> {
            UserModel userModel = new UserModel();
            adminList.add(userModel.toUserModel(s));
        });

        model.addAttribute("admins", adminList);
        return "admins";
    }

    @PostMapping("/admins")
    public String addAdmin(RegisterForm registerForm) {
        userService.save(registerForm.toUser(), "ADMIN");
        return "redirect:/admins";
    }

    @GetMapping("/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable String id) {
        userService.deleteById(Long.parseLong(id));
        return "redirect:/admins";
    }

    @GetMapping("/editAdmin")
    public String editAdmin(HttpServletRequest request, Model model) {
        String id = request.getParameter("id");
        User adminToEdit = userService.getUserById(Long.parseLong(id));
        model.addAttribute("adminToEdit", adminToEdit);
        return "EditAdminData";
    }

    @PostMapping("/editAdmin")
        public String editAdmin(UserModel userModel){
        User editedUser = userService.getUserById(Long.parseLong(userModel.getId()));
        editedUser.setName(userModel.getName());
        editedUser.setLastName(userModel.getLastName());
        editedUser.setEmail(userModel.getEmail());
        userService.save(editedUser,"ADMIN");
        return "redirect:/admins";
        }


    @ModelAttribute
    public UserModel adminModel() {
        return new UserModel();
    }

    @ModelAttribute
    public RegisterForm registerForm() {
        return new RegisterForm();
    }
}
