package ru.Managers.Tool;

import ru.Entity.Tool;
import ru.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolManagers extends CrudRepository<Tool, Long> {
    List<Tool> findAll();
    List<Tool> findToolByUserAndIsDeleted(Long userId,Byte IsDeleted);

}
