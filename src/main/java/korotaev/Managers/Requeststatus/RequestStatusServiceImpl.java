package korotaev.Managers.Requeststatus;

import com.google.common.collect.Lists;
import korotaev.Entity.Request;
import korotaev.Entity.Requeststatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaRequestStatusService")
@Repository
@Transactional
public class RequestStatusServiceImpl {

    @Autowired
    private RequestStatusManagers requestStatusManagers;
    private GenericXmlApplicationContext ctx;

    public RequestStatusServiceImpl(GenericXmlApplicationContext context) {
        ctx = context;
        requestStatusManagers = ctx.getBean(RequestStatusManagers.class);
    }

    public RequestStatusServiceImpl() {
    }

    public List<Requeststatus> findAll() {
        return Lists.newArrayList(requestStatusManagers.findAll());
    }



}