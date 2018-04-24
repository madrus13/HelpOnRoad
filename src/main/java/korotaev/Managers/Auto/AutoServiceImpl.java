package korotaev.Managers.Auto;

import com.google.common.collect.Lists;
import korotaev.Entity.Achievement;
import korotaev.Entity.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaAutoService")
@Repository
@Transactional
public class AutoServiceImpl {

    @Autowired
    private AutoManagers autoManagers;
    private GenericXmlApplicationContext ctx;

    public AutoServiceImpl(GenericXmlApplicationContext context) {
        ctx = context;
        autoManagers = ctx.getBean(AutoManagers.class);
    }

    public AutoServiceImpl() {
    }

    public List<Auto> findAll() {
        return Lists.newArrayList(autoManagers.findAll());
    }



}