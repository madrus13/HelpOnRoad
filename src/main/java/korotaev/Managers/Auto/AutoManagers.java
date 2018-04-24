package korotaev.Managers.Auto;

import korotaev.Entity.Achievement;
import korotaev.Entity.Auto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoManagers extends CrudRepository<Auto, Long> {
    List<Auto> findAll();
}
