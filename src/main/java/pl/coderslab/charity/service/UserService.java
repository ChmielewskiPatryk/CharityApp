package pl.coderslab.charity.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Role;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
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

    public void save(User user, String role){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Set<Role> userRoleSet = new HashSet<>();
        Role userRole = roleRepository.getRoleByRole(role);
        userRoleSet.add(userRole);
        user.setRoles(userRoleSet);
        userRepository.save(user);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public User getUserById(Long id){
        return userRepository.getUserById(id);
    }



    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    public User findUserByEmail(String email){
        return userRepository.getUserByEmail(email);

    }
    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public List<User> getUserWithSpecificRole(String role){
        return userRepository.findAllUsersByRole(role);
    }
}
