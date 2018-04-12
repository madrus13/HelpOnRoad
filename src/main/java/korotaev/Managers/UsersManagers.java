package korotaev.Managers;

import korotaev.Models.Md.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersManagers extends CrudRepository<User, Long> {
    List<User> findMD_UsersByName(String name);
}
