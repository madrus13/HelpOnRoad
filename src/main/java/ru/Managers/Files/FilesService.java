package ru.Managers.Files;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.Entity.Files;

import java.util.List;

@Service("jpaFilesService")
@Repository
@Transactional
public class FilesService {

    @Autowired
    private FilesManagers filesManagers;
    private GenericXmlApplicationContext ctx;

    public FilesService(GenericXmlApplicationContext context) {
        ctx = context;
        filesManagers = ctx.getBean(FilesManagers.class);
    }

    public FilesService() {
    }

    public List<Files> findAll() {
        return Lists.newArrayList(filesManagers.findAll());
    }

    public Files findFirstById(Long id) {
        return filesManagers.findFirstById(id);
    }


}