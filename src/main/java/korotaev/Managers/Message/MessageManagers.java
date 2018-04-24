package korotaev.Managers.Message;

import korotaev.Entity.Auto;
import korotaev.Entity.Message;
import korotaev.Entity.Messagetype;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageManagers extends CrudRepository<Message, Long> {
    List<Message> findAll();
}
