package korotaev.main;

import korotaev.Service.WebServiceMain;

public class Main {
    private WebServiceMain webService;
    public static void main(String[] args) {

        WebServiceMain webService = new WebServiceMain();

        webService.insertUser("ololoshka432","3","pass123");
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
