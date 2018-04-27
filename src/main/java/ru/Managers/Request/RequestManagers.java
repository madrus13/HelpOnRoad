package ru.Managers.Request;

import ru.Entity.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestManagers extends CrudRepository<Request, Long> {
    List<Request> findAll();
}
