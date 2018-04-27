package ru.Managers.Achievement;

import com.google.common.collect.Lists;
import ru.Entity.Achievement;
import ru.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaAchievService")
@Repository
@Transactional
public class AchievService {

    @Autowired
    private AchievManagers achievManagers;
    private GenericXmlApplicationContext ctx;

    public AchievService(GenericXmlApplicationContext context) {
        ctx = context;
        achievManagers = ctx.getBean(AchievManagers.class);
    }

    public AchievService() {
    }

    public List<Achievement> findAll() {
        return Lists.newArrayList(achievManagers.findAll());
    }

    public List<Achievement> findAchievementByUser(User user) {
        return Lists.newArrayList(achievManagers.findAchievementByUser(user));
    }

}