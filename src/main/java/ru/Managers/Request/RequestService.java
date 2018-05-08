package ru.Managers.Request;

import com.google.common.collect.Lists;
import ru.Entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaRequestService")
@Repository
@Transactional
public class RequestService {

    @Autowired
    private RequestManagers requestManagers;
    private GenericXmlApplicationContext ctx;

    public RequestService(GenericXmlApplicationContext context) {
        ctx = context;
        requestManagers = ctx.getBean(RequestManagers.class);
    }

    public RequestService() {
    }

    public List<Request> findAll() {
        return Lists.newArrayList(requestManagers.findAll());
    }
    public List<Request> findRequestByCreationUser(Long userId) {
        return Lists.newArrayList(requestManagers.findRequestByCreationUser(userId));
    }



}