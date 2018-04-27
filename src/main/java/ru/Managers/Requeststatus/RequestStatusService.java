package ru.Managers.Requeststatus;

import com.google.common.collect.Lists;
import ru.Entity.Requeststatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaRequestStatusService")
@Repository
@Transactional
public class RequestStatusService {

    @Autowired
    private RequestStatusManagers requestStatusManagers;
    private GenericXmlApplicationContext ctx;

    public RequestStatusService(GenericXmlApplicationContext context) {
        ctx = context;
        requestStatusManagers = ctx.getBean(RequestStatusManagers.class);
    }

    public RequestStatusService() {
    }

    public List<Requeststatus> findAll() {
        return Lists.newArrayList(requestStatusManagers.findAll());
    }



}