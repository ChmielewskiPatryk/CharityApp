package pl.coderslab.charity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.model.UserModel;
import pl.coderslab.charity.service.RoleService;
import pl.coderslab.charity.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class test {

    private final UserService userService;
    private final RoleService roleService;

    public test(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/test")
    public String getLoging() {

        List<User> admin = userService.getUserWithSpecificRole("ADMIN");
        List<UserModel> adminList = new ArrayList<>();
        admin.forEach(s -> {
            UserModel userModel = new UserModel();
            System.out.println(s.toString());
            userModel.toUserModel(s);
            adminList.add(userModel);
        });
        return admin.toString();

    }
}
