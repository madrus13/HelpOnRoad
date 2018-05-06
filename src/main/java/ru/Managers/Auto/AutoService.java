package ru.Managers.Auto;

import com.google.common.collect.Lists;
import ru.Entity.Auto;
import ru.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaAutoService")
@Repository
@Transactional
public class AutoService {

    @Autowired
    private AutoManagers autoManagers;
    private GenericXmlApplicationContext ctx;

    public AutoService(GenericXmlApplicationContext context) {
        ctx = context;
        autoManagers = ctx.getBean(AutoManagers.class);
    }

    public AutoService() {
    }

    public List<Auto> findAll() {
        return Lists.newArrayList(autoManagers.findAll());
    }

    public List<Auto> findAutoByUser(Long user) {
        return Lists.newArrayList(autoManagers.findAutoByUser(user));
    }

}