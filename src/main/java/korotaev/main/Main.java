package korotaev.main;

import korotaev.Managers.UsersManagers;
import korotaev.Models.Md.User;
import org.apache.log4j.BasicConfigurator;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        BasicConfigurator.configure();


        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-config.xml"); //move from src.main.java to src.main.resources
        ctx.refresh();

        /*
        UsersManagers service = ctx.getBean("jpaUsersManagers", UsersManagers.class);
        List<User> users = service.findMD_UsersByName("rus");

        for (User user: users
                ) {
            System.out.println(user.getEmail() + user.getAutosById().toString());
        }*/
        }


}
