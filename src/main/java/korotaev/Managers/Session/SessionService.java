package korotaev.Managers.Session;

import com.google.common.collect.Lists;
import korotaev.Entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaSessionService")
@Repository
@Transactional
public class SessionService {

    @Autowired
    private SessionManagers sessionManagers;
    private GenericXmlApplicationContext ctx;

    public SessionService(GenericXmlApplicationContext context) {
        ctx = context;
        sessionManagers = ctx.getBean(SessionManagers.class);
    }

    public SessionService() {
    }

    public List<Session> findAll() {
        return Lists.newArrayList(sessionManagers.findAll());
    }

    public List<Session> findSessionByToken(String token) {
        return Lists.newArrayList(sessionManagers.findSessionByToken(token));
    }
}