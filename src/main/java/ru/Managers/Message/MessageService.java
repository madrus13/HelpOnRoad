package ru.Managers.Message;

import com.google.common.collect.Lists;
import org.springframework.data.domain.PageRequest;
import ru.Entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("jpaMessageService")
@Repository
@Transactional
public class MessageService {

    @Autowired
    private MessageManagers messageManagers;
    private GenericXmlApplicationContext ctx;

    public MessageService(GenericXmlApplicationContext context) {
        ctx = context;
        messageManagers = ctx.getBean(MessageManagers.class);
    }

    public MessageService() {
    }

    public List<Message> findAll() {
        return Lists.newArrayList(messageManagers.findAll());
    }

    public List<Message> findMessageByRegion(Long region, int startRow, int pageSize) {
        return Lists.newArrayList(messageManagers.findMessageByRegionOrderById(region, new PageRequest(startRow,pageSize)));
    }

    public List<Message> findMessageByRegionAndAndIdAfter(Long region, Long Id, int pageSize) {
        return Lists.newArrayList(messageManagers.findMessageByRegionAndIdGreaterThan(region,Id, new PageRequest(0,pageSize)));
    }

    public List<Message> findMessageByReqionAndCreationDateBetweenOrderByIdAsc(Long region,
                                                                               Date startDate,
                                                                               Date endDate,
                                                                               int page,
                                                                               int pageSize) {
        return Lists.newArrayList(messageManagers.findMessageByRegionAndCreationDateBetweenOrderByIdAsc(
                region, startDate, endDate, new PageRequest(page,pageSize)));
    }

    public List<Message> findAllMessageByRequest(Long request, int startRow, int pageSize) {
        return Lists.newArrayList(messageManagers.findMessageByRequest(request, new PageRequest(startRow,pageSize)));
    }


}