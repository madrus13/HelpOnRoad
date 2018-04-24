package korotaev.Managers.Region;

import com.google.common.collect.Lists;
import korotaev.Entity.Message;
import korotaev.Entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaRegionService")
@Repository
@Transactional
public class RegionService {

    @Autowired
    private RegionManagers regionManagers;
    private GenericXmlApplicationContext ctx;

    public RegionService(GenericXmlApplicationContext context) {
        ctx = context;
        regionManagers = ctx.getBean(RegionManagers.class);
    }

    public RegionService() {
    }

    public List<Region> findAll() {
        return Lists.newArrayList(regionManagers.findAll());
    }



}