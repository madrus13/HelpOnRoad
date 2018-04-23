package korotaev.Managers.User;

import korotaev.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersManagers extends CrudRepository<User, Long> {
    List<User> findUsersByName(String name);
    List<User> findAll();
    List<User> findUsersById(long Id);
}
