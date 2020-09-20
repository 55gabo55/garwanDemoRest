package sk.gabrielkostialik.garwanDemoRest.repository;

import org.springframework.data.repository.CrudRepository;
import sk.gabrielkostialik.garwanDemoRest.model.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User getUserByUsername(String username);
    List<User> findAll();
}
