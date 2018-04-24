package korotaev.Managers.Achievmenttype;

import com.google.common.collect.Lists;
import korotaev.Entity.Achievmenttype;
import korotaev.Entity.TransmissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaAchievTypeService")
@Repository
@Transactional
public class AchievTypeServiceImpl {

    @Autowired
    private AchievTypeManagers achievTypeManagers;
    private GenericXmlApplicationContext ctx;

    public AchievTypeServiceImpl(GenericXmlApplicationContext context) {
        ctx = context;
        achievTypeManagers = ctx.getBean(AchievTypeManagers.class);
    }

    public AchievTypeServiceImpl() {
    }

    public List<Achievmenttype> findAll() {
        return Lists.newArrayList(achievTypeManagers.findAll());
    }



}