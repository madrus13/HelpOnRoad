package korotaev.Managers.Transmissiontype;

import com.google.common.collect.Lists;
import korotaev.Entity.TransmissionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaTrTypeService")
@Repository
@Transactional
public class TrTypeServiceImpl {

    @Autowired
    private TrTypeManagers trTypeManagers;
    private GenericXmlApplicationContext ctx;

    public TrTypeServiceImpl(GenericXmlApplicationContext context) {
        ctx = context;
        trTypeManagers = ctx.getBean(TrTypeManagers.class);
    }

    public TrTypeServiceImpl() {
    }

    public List<TransmissionType> findAll() {
        return Lists.newArrayList(trTypeManagers.findAll());
    }


}