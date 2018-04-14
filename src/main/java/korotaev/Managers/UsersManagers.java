package korotaev.Managers;

import korotaev.Models.Md.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersManagers extends CrudRepository<User, Long> {
    List<User> findMD_UsersByName(String name);
    List<User> findUsersByNameLike(String name);

}
