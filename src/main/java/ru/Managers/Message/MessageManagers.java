package ru.Managers.Message;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.Entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageManagers extends CrudRepository<Message, Long> {
    List<Message> findAll();
    List<Message> findMessageByRegionAndAndIdGreaterThan(Long region, Long Id, Pageable pageable);
}
