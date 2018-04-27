package ru.Managers.User;
import com.google.common.collect.Lists;
import ru.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
@Service("jpaUsersService")
@Repository
@Transactional
public class UsersService {

    @Autowired
    private UsersManagers usersManagers;
    private GenericXmlApplicationContext ctx;

    public UsersService(GenericXmlApplicationContext context) {
        ctx = context;
        usersManagers = ctx.getBean(UsersManagers.class);
    }

    public UsersService() {
    }


    public List<User> findAll() {
        return Lists.newArrayList(usersManagers.findAll());
    }

    public User findOneUserByName (String name) {
        ArrayList<User> userList = new ArrayList<User>();
        userList.addAll(usersManagers.findUsersByName(name));
        if (userList.isEmpty()) {
            return null;
        }
        return userList.get(0);
    }
}