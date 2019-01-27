package ru.Managers.Files;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.Entity.Achievmenttype;
import ru.Entity.Files;
import ru.Entity.Request;

import java.util.List;

@Repository
public interface FilesManagers extends CrudRepository<Files, Long> {
    List<Files> findAll();
    Files findFirstById(Long userId);
}
