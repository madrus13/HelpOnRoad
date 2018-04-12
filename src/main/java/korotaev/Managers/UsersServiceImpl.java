package korotaev.Managers;
import com.google.common.collect.Lists;
import korotaev.Models.Md.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service("jpaContactService")
@Repository
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersManagers usersManagers;

    public List<User> findAll() {
        return Lists.newArrayList(usersManagers.findAll());
    }

    public List<User> findByName (String name) {

        return usersManagers.findMD_UsersByName(name);
    }

}