package korotaev.Managers.Request;

import com.google.common.collect.Lists;
import korotaev.Entity.Region;
import korotaev.Entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaRequestService")
@Repository
@Transactional
public class RequestServiceImpl {

    @Autowired
    private RequestManagers requestManagers;
    private GenericXmlApplicationContext ctx;

    public RequestServiceImpl(GenericXmlApplicationContext context) {
        ctx = context;
        requestManagers = ctx.getBean(RequestManagers.class);
    }

    public RequestServiceImpl() {
    }

    public List<Request> findAll() {
        return Lists.newArrayList(requestManagers.findAll());
    }



}