package ru.Managers.Requesttype;

import ru.Entity.Requesttype;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestTypeManagers extends CrudRepository<Requesttype, Long> {
    List<Requesttype> findAll();
}
