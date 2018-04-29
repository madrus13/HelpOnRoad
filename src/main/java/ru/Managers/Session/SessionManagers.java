package ru.Managers.Session;

import ru.Entity.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionManagers extends CrudRepository<Session, Long> {
    List<Session> findAll();
    List<Session> findSessionByToken(String token);
    List<Session> findSessionByUser(Long userId);
}
