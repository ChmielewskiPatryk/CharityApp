package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByEmail(String email);

    boolean existsByEmail(String email);

    void deleteById(Long id);

    User getUserById(Long id);
    @Query("SELECT u FROM User u JOIN u.roles r WHERE r.role=?1")
    List<User> findAllUsersByRole(String role);
}
