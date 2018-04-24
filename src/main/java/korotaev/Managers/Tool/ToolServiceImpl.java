package korotaev.Managers.Tool;

import com.google.common.collect.Lists;
import korotaev.Entity.Tool;
import korotaev.Entity.Tooltypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaToolService")
@Repository
@Transactional
public class ToolServiceImpl {

    @Autowired
    private ToolManagers trTypeManagers;
    private GenericXmlApplicationContext ctx;

    public ToolServiceImpl(GenericXmlApplicationContext context) {
        ctx = context;
        trTypeManagers = ctx.getBean(ToolManagers.class);
    }

    public ToolServiceImpl() {
    }

    public List<Tool> findAll() {
        return Lists.newArrayList(trTypeManagers.findAll());
    }

}