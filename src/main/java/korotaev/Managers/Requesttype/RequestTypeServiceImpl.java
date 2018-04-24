package korotaev.Managers.Requesttype;

import com.google.common.collect.Lists;
import korotaev.Entity.Requesttype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaRequestTypeService")
@Repository
@Transactional
public class RequestTypeServiceImpl {

    @Autowired
    private RequestTypeManagers requestTypeManagers;
    private GenericXmlApplicationContext ctx;

    public RequestTypeServiceImpl(GenericXmlApplicationContext context) {
        ctx = context;
        requestTypeManagers = ctx.getBean(RequestTypeManagers.class);
    }

    public RequestTypeServiceImpl() {
    }

    public List<Requesttype> findAll() {
        return Lists.newArrayList(requestTypeManagers.findAll());
    }



}