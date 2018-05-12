package ru.Managers.Request;

import com.google.common.collect.Lists;
import ru.Entity.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaRequestService")
@Repository
@Transactional
public class RequestService {

    @Autowired
    private RequestManagers requestManagers;
    private GenericXmlApplicationContext ctx;

    public RequestService(GenericXmlApplicationContext context) {
        ctx = context;
        requestManagers = ctx.getBean(RequestManagers.class);
    }

    public RequestService() {
    }

    public List<Request> findAll() {
        return Lists.newArrayList(requestManagers.findAll());
    }
    public List<Request> findRequestByCreationUser(Long userId) {
        return Lists.newArrayList(requestManagers.findRequestByCreationUser(userId));
    }
    public List<Request> findRequestByResolvedByUserAndStatusAndTypeIn(Long userId, Long statusId, List<Long> typeIds) {
        return Lists.newArrayList(requestManagers.findRequestByResolvedByUserAndStatusAndTypeIn(userId,statusId,typeIds));
    }
    public List<Request> findRequestByResolvedByUserAndStatus(Long userId,Long statusId) {
        return Lists.newArrayList(requestManagers.findRequestByResolvedByUserAndStatus(userId,statusId));
    }
    public List<Request> findRequestByRegionAndStatusAndTypeIn(Long regionId,Long statusId, List<Long> typeIds) {
        return Lists.newArrayList(requestManagers.findRequestByRegionAndStatusAndTypeIn(regionId, statusId, typeIds));
    }
    public List<Request> findRequestByRegionAndStatus(Long regionId,Long statusId) {
        return Lists.newArrayList(requestManagers.findRequestByRegionAndStatus(regionId, statusId));
    }
    public List<Request> findRequestByCreationUserAndStatus(Long userId,Long statusId) {
        return Lists.newArrayList(requestManagers.findRequestByCreationUserAndStatus(userId, statusId));
    }
}