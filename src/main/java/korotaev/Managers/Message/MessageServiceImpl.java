package korotaev.Managers.Message;

import com.google.common.collect.Lists;
import korotaev.Entity.Auto;
import korotaev.Entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaMessageService")
@Repository
@Transactional
public class MessageServiceImpl {

    @Autowired
    private MessageManagers messageManagers;
    private GenericXmlApplicationContext ctx;

    public MessageServiceImpl(GenericXmlApplicationContext context) {
        ctx = context;
        messageManagers = ctx.getBean(MessageManagers.class);
    }

    public MessageServiceImpl() {
    }

    public List<Message> findAll() {
        return Lists.newArrayList(messageManagers.findAll());
    }



}