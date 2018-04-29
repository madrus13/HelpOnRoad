package ru.Managers.Session;

import com.google.common.collect.Lists;
import ru.Entity.Session;
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

    public Session findSessionByToken(String token) {
        if (sessionManagers.findSessionByToken(token).isEmpty() == false) {
            return Lists.newArrayList(sessionManagers.findSessionByToken(token)).get(0);
        }
        return null;
    }

    public Session findSessionByUserId(Long userId) {
        Session result = null;
        List<Session>  findSession =   sessionManagers.findSessionByUser(userId);
        if (findSession.isEmpty() == false) {
            result = findSession.get(0);
        }
        return result;
    }
}