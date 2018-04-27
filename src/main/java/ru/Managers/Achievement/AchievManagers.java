package ru.Managers.Achievement;

import ru.Entity.Achievement;
import ru.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievManagers extends CrudRepository<Achievement, Long> {
    List<Achievement> findAll();
    List<Achievement> findAchievementByUser(User user);
}
