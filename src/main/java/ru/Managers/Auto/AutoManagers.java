package ru.Managers.Auto;

import ru.Entity.Auto;
import ru.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoManagers extends CrudRepository<Auto, Long> {
    List<Auto> findAll();
    List<Auto> findAutoByUser(Long user);
}
