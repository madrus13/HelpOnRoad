package korotaev.Managers;

import korotaev.Models.Md.User;

import java.util.List;

public interface UsersService {
    List<User> findByName(String name);
    List<User> findByNameLike(String name);
    List<User> findAll();

}
