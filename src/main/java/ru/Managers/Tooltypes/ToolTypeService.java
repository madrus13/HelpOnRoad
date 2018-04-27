package ru.Managers.Tooltypes;

import com.google.common.collect.Lists;
import ru.Entity.Tooltypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaToolTypeService")
@Repository
@Transactional
public class ToolTypeService {

    @Autowired
    private ToolTypeManagers trTypeManagers;
    private GenericXmlApplicationContext ctx;

    public ToolTypeService(GenericXmlApplicationContext context) {
        ctx = context;
        trTypeManagers = ctx.getBean(ToolTypeManagers.class);
    }

    public ToolTypeService() {
    }

    public List<Tooltypes> findAll() {
        return Lists.newArrayList(trTypeManagers.findAll());
    }

}