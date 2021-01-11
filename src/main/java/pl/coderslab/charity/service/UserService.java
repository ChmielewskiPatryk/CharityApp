package pl.coderslab.charity.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService  {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public void save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> userRoleSet = new HashSet<>();
        Role userRole = roleRepository.getOne(1L);
        userRoleSet.add(userRole);
        user.setRoles(userRoleSet);
        userRepository.save(user);
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    public User findUserByEmail(String email){
        return userRepository.getUserByEmail(email);

    }
}
