package ru.Managers.Messagetype;

import com.google.common.collect.Lists;
import ru.Entity.Messagetype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaMessageTypeService")
@Repository
@Transactional
public class MessageTypeService {

    @Autowired
    private MessageTypeManagers messageTypeManagers;
    private GenericXmlApplicationContext ctx;

    public MessageTypeService(GenericXmlApplicationContext context) {
        ctx = context;
        messageTypeManagers = ctx.getBean(MessageTypeManagers.class);
    }

    public MessageTypeService() {
    }

    public List<Messagetype> findAll() {
        return Lists.newArrayList(messageTypeManagers.findAll());
    }


}