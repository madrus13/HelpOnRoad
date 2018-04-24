package korotaev.Managers.Achievement;

import korotaev.Entity.Achievement;
import korotaev.Entity.Achievmenttype;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievManagers extends CrudRepository<Achievement, Long> {
    List<Achievement> findAll();
}
