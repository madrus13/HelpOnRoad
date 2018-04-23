package korotaev.main;

import korotaev.Entity.User;
import korotaev.Managers.User.UsersServiceImpl;
import korotaev.Service.WebServiceMain;
import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

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

        initContextMain();

        WebServiceMain webService = new WebServiceMain(ctx);
        UsersServiceImpl sd = new UsersServiceImpl(ctx);
        List<User> ololoshka432 = sd.findByName("ololoshka432");
        int i = 0;
        for (User user: ololoshka432
                ) {
            i++;
            System.out.println(i + ") " +  user.getName());
        }
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
