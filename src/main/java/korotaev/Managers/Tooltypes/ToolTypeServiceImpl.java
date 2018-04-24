package korotaev.Managers.Tooltypes;

import com.google.common.collect.Lists;
import korotaev.Entity.Tooltypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaToolTypeService")
@Repository
@Transactional
public class ToolTypeServiceImpl {

    @Autowired
    private ToolTypeManagers trTypeManagers;
    private GenericXmlApplicationContext ctx;

    public ToolTypeServiceImpl(GenericXmlApplicationContext context) {
        ctx = context;
        trTypeManagers = ctx.getBean(ToolTypeManagers.class);
    }

    public ToolTypeServiceImpl() {
    }

    public List<Tooltypes> findAll() {
        return Lists.newArrayList(trTypeManagers.findAll());
    }

}