package korotaev.Managers.Achievmenttype;

import korotaev.Entity.Achievmenttype;
import korotaev.Entity.TransmissionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievTypeManagers extends CrudRepository<Achievmenttype, Long> {
    List<Achievmenttype> findAll();
}
