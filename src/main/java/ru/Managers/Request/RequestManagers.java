package ru.Managers.Request;

import ru.Entity.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestManagers extends CrudRepository<Request, Long> {
    List<Request> findAll();
    List<Request> findRequestByCreationUser(Long userId);
    List<Request> findRequestByResolvedByUserAndStatusAndTypeIn(Long userId, Long statusId, List<Long> typeIds);
    List<Request> findRequestByResolvedByUserAndStatus(Long userId, Long statusId);
    List<Request> findRequestByRegionAndStatusAndTypeIn  (Long userId, Long statusId, List<Long> typeIds);
    List<Request> findRequestByRegionAndStatus  (Long userId, Long statusId);
    //Получить текущий активный запрос пользователя ( если указать статус Open)
    List<Request> findRequestByCreationUserAndStatus  (Long userId, Long statusId);
}
