package ru.Managers.Tooltypes;

import ru.Entity.Tooltypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolTypeManagers extends CrudRepository<Tooltypes, Long> {
    List<Tooltypes> findAll();
}
