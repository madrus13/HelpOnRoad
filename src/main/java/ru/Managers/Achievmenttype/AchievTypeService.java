package ru.Managers.Achievmenttype;

import com.google.common.collect.Lists;
import ru.Entity.Achievmenttype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaAchievTypeService")
@Repository
@Transactional
public class AchievTypeService {

    @Autowired
    private AchievTypeManagers achievTypeManagers;
    private GenericXmlApplicationContext ctx;

    public AchievTypeService(GenericXmlApplicationContext context) {
        ctx = context;
        achievTypeManagers = ctx.getBean(AchievTypeManagers.class);
    }

    public AchievTypeService() {
    }

    public List<Achievmenttype> findAll() {
        return Lists.newArrayList(achievTypeManagers.findAll());
    }



}