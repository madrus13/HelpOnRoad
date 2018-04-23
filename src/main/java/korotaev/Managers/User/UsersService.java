package korotaev.Managers.User;

import korotaev.Entity.User;

import java.util.List;

public interface UsersService extends  UsersManagers {
    List<User> findByName(String name);
    List<User> findAll();
    List<User> findUsersById(long Id);
}
