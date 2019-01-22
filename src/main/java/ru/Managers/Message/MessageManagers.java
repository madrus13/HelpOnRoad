package ru.Managers.Message;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import ru.Entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MessageManagers extends CrudRepository<Message, Long> {
    List<Message> findAll();
    List<Message> findMessageByRegionOrderById(Long region, Pageable pageable);
    List<Message> findMessageByRequest(Long Request, Pageable pageable);
    List<Message> findMessageByRegionAndIdGreaterThan(Long region, Long Id, Pageable pageable);
    List<Message> findMessageByRegionAndCreationDateBetweenOrderByIdAsc(Long region, Date start, Date end,  Pageable pageable);
}
