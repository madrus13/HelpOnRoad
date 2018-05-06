package ru.Managers.Tool;

import com.google.common.collect.Lists;
import ru.Entity.Tool;
import ru.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaToolService")
@Repository
@Transactional
public class ToolService {

    @Autowired
    private ToolManagers trTypeManagers;
    private GenericXmlApplicationContext ctx;

    public ToolService(GenericXmlApplicationContext context) {
        ctx = context;
        trTypeManagers = ctx.getBean(ToolManagers.class);
    }

    public ToolService() {
    }

    public List<Tool> findAll() {
        return Lists.newArrayList(trTypeManagers.findAll());
    }
    public List<Tool> findToolByUser(Long userId) {
        return Lists.newArrayList(trTypeManagers.findToolByUser (userId));
    }
}