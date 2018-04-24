package korotaev.Managers.Session;

import korotaev.Entity.Session;
import korotaev.Entity.Tooltypes;
import korotaev.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionManagers extends CrudRepository<Session, Long> {
    List<Session> findAll();
    List<Session> findSessionByToken(String token);
    List<Session> findSessionByUser(User user);
}
