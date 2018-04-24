package korotaev.Managers.Requeststatus;

import korotaev.Entity.Request;
import korotaev.Entity.Requeststatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestStatusManagers extends CrudRepository<Requeststatus, Long> {
    List<Requeststatus> findAll();
}
