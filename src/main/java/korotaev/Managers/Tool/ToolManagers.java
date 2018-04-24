package korotaev.Managers.Tool;

import korotaev.Entity.Tool;
import korotaev.Entity.Tooltypes;
import korotaev.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolManagers extends CrudRepository<Tool, Long> {
    List<Tool> findAll();
    List<Tool> findToolByUser(User user);
}
