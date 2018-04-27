package ru.main;

import ru.Service.WebServiceMain;
import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    private static GenericXmlApplicationContext ctx;
    private WebServiceMain webService;


    public static void initContextMain(){
        BasicConfigurator.configure();
        ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-config.xml");
        ctx.refresh();
    }


    public static void main(String[] args) {

        //initContextMain();

        //WebServiceMain webService = new WebServiceMain(ctx);
        //UsersService sd = new UsersService(ctx);
        //TrTypeService ff = new TrTypeService(ctx);



//        int i = 0;
//        for (TransmissionType ttype: ff.findAll()
//                ) {
//            i++;
//            System.out.println(i + ") " +  ttype.getName());
//        }
        //WebServiceMain webService = new WebServiceMain();

        //webService.insertUser("ololoshka432","3","pass123");
        /*
        UsersManagers service = ctx.getBean(UsersManagers.class);
        List<User> users = service.findUsersByNameContaining("rus");
        int i = 0;
        for (User user: users
                ) {
            i++;
            System.out.println(i + ") " +  user.getName());
        } */
        }



}
