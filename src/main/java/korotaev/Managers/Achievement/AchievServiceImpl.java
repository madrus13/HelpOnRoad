package korotaev.Managers.Achievement;

import com.google.common.collect.Lists;
import korotaev.Entity.Achievement;
import korotaev.Entity.Achievmenttype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaAchievService")
@Repository
@Transactional
public class AchievServiceImpl {

    @Autowired
    private AchievManagers achievManagers;
    private GenericXmlApplicationContext ctx;

    public AchievServiceImpl(GenericXmlApplicationContext context) {
        ctx = context;
        achievManagers = ctx.getBean(AchievManagers.class);
    }

    public AchievServiceImpl() {
    }

    public List<Achievement> findAll() {
        return Lists.newArrayList(achievManagers.findAll());
    }



}