package korotaev.Managers.Messagetype;

import com.google.common.collect.Lists;
import korotaev.Entity.Messagetype;
import korotaev.Entity.TransmissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaMessageTypeService")
@Repository
@Transactional
public class MessageTypeServiceImpl {

    @Autowired
    private MessageTypeManagers messageTypeManagers;
    private GenericXmlApplicationContext ctx;

    public MessageTypeServiceImpl(GenericXmlApplicationContext context) {
        ctx = context;
        messageTypeManagers = ctx.getBean(MessageTypeManagers.class);
    }

    public MessageTypeServiceImpl() {
    }

    public List<Messagetype> findAll() {
        return Lists.newArrayList(messageTypeManagers.findAll());
    }


}