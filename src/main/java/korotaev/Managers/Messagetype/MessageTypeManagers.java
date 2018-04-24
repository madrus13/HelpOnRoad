package korotaev.Managers.Messagetype;

import korotaev.Entity.Messagetype;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageTypeManagers extends CrudRepository<Messagetype, Long> {
    List<Messagetype> findAll();
}
