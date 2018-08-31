package ru.Managers.User;

import ru.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersManagers extends CrudRepository<User, Long> {
    List<User> findUsersByName(String name);
    User findFirstByNameAndEmail(String name, String email );
    User findFirstByName(String name);
    User findFirstByEmail(String email );
    List<User> findAll();
}
