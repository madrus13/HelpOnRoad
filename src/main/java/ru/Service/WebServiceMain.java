package ru.Service;

import org.joda.time.DateTime;
import ru.Entity.Achievement;
import ru.Entity.Session;
import ru.Managers.Achievement.AchievService;
import ru.Managers.Achievmenttype.AchievTypeService;
import ru.Managers.Auto.AutoService;
import ru.Managers.Message.MessageService;
import ru.Managers.Messagetype.MessageTypeService;
import ru.Managers.Region.RegionManagers;
import ru.Managers.Region.RegionService;
import ru.Managers.Request.RequestService;
import ru.Managers.Requesttype.RequestTypeService;
import ru.Managers.Session.SessionManagers;
import ru.Managers.Session.SessionService;
import ru.Managers.Tool.ToolService;
import ru.Managers.Tooltypes.ToolTypeService;
import ru.Managers.Transmissiontype.TrTypeService;
import ru.Managers.User.UsersManagers;
import ru.Entity.User;
import ru.Managers.User.UsersService;
import org.apache.log4j.BasicConfigurator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.List;

import static com.sun.deploy.util.SessionState.save;
import static com.sun.javafx.css.StyleManager.getErrors;


@WebService
@Transactional
public class WebServiceMain {
    private static String INVALID_TOKEN = "INVALID TOKEN";
    private static String INVALIDE_DATA = "INVALID DATA";
    private GenericXmlApplicationContext ctx;

    private UsersManagers usersManagers;
    private RegionManagers regionManagers;
    private SessionManagers sessionManagers;

    private UsersService userService;
    private SessionService sessionService;
    private RegionService regionService;
    private AchievService achievService;
    private AchievTypeService achievTypeService;
    private AutoService autoService;
    private MessageService messageService;
    private MessageTypeService messageTypeService;
    private RequestService requestService;
    private RequestTypeService requestTypeService;
    private ToolService toolService;
    private ToolTypeService toolTypeService;
    private TrTypeService trTypeService;


    public WebServiceMain() {
    }

    private String saveUserAndRetJson(User user) {
        try {
            usersManagers = ctx.getBean(UsersManagers.class);
            if (usersManagers != null) {
                usersManagers.save(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return INVALIDE_DATA;
        }
        return objToJson(user);
    }


    private String objToJson(Object obj) {
        String res = INVALIDE_DATA;
        ObjectMapper mapper = new ObjectMapper();
        try {
            res = mapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @WebMethod()
    public String insertUser(
                            @WebParam(name="name")   String name,
                            @WebParam(name="region") Integer region,
                            @WebParam(name="password") String password,
                            @WebParam(name="email") String email
                            ) {
        initMainCfg();
        User user = new User();
        user.setName(name);
        user.setCreationDate(new Timestamp(System.currentTimeMillis()));
        user.setModifyDate(new Timestamp(System.currentTimeMillis()));
        user.setPassword(password);
        user.setEmail(email);
        user.setStatus(2); //Const : common user
        user.setRegion(region);

        return saveUserAndRetJson(user);
    }


    private String sha1(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
                hexString.append(String.format("%02X", 0xFF & messageDigest[i]));
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    @WebMethod
    public String getSessionToken(
            @WebParam(name="name") String name,
            @WebParam(name="password") String password)
    {

        String res = INVALIDE_DATA;
        User user = null;
        Session findSession = null;

        initMainCfg();
        user = userService.findOneUserByName(name);
        if (user !=null && user.getPassword().equals(password))
        {
            findSession = sessionService.findSessionByUserId(user.getId());

            if (findSession !=null && findSession.getToken().equals("")) {
                res =  findSession.getToken();
            }
            else {
                if (user!=null) {
                    ru.Entity.Session newSession = new ru.Entity.Session();
                    newSession.setUser(user.getId());
                    newSession.setToken(sha1(user.getName()+user.getPassword()+ DateTime.now().toString()));
                    sessionManagers.save(newSession);
                    res = objToJson(newSession);
                }
            }
        }

        return res;
    }


    @WebMethod
    public String getUserInfo(
            @WebParam(name="sessionToken") String sessionToken) {
        initMainCfg();
        String result = "";

        if (isTokenCorrect(sessionToken))
        {
            Session session = null;
            if (sessionService != null) {
                session = sessionService.findSessionByToken(sessionToken);
            }
            result =  objToJson(session.getUserByUser());
        }
        else {
            result = INVALID_TOKEN;
        }
        return result;
    }

    @WebMethod
    public String getAllMessageTypes(
            @WebParam(name="sessionToken") String sessionToken) {
        initMainCfg();
        String result = "";

        if (isTokenCorrect(sessionToken))
        {
            result =  objToJson(messageTypeService.findAll());
        }
        else {
            result = INVALID_TOKEN;
        }
        return result;
    }

    @WebMethod
    public String getAllRequestType(
            @WebParam(name="sessionToken") String sessionToken) {
        initMainCfg();
        String result = "";

        if (isTokenCorrect(sessionToken))
        {
            result =  objToJson(requestTypeService.findAll());
        }
        else {
            result = INVALID_TOKEN;
        }
        return result;
    }

    @WebMethod
    public String getAllTransmissionType(
            @WebParam(name="sessionToken") String sessionToken) {
        initMainCfg();
        String result = "";

        if (isTokenCorrect(sessionToken))
        {
            result =  objToJson(trTypeService.findAll());
        }
        else {
            result = INVALID_TOKEN;
        }
        return result;
    }

    @WebMethod
    public String getAllToolType(
            @WebParam(name="sessionToken") String sessionToken) {
        initMainCfg();
        String result = "";

        if (isTokenCorrect(sessionToken))
        {
            result =  objToJson(toolTypeService.findAll());
        }
        else {
            result = INVALID_TOKEN;
        }
        return result;
    }

    @WebMethod
    public String getAllTachievmenttype(
            @WebParam(name="sessionToken") String sessionToken) {
        initMainCfg();
        String result = "";

        if (isTokenCorrect(sessionToken))
        {
            result =  objToJson(achievTypeService.findAll());
        }
        else {
            result = INVALID_TOKEN;
        }
        return result;
    }


    @WebMethod
    public String getAllTachievmentByUser(
            @WebParam(name="sessionToken") String sessionToken,
            @WebParam(name="user") Long userId) {
        initMainCfg();
        String result = "";
        User user = null;
        List<Achievement> achievs = null;
        if (isTokenCorrect(sessionToken))
        {
            user = usersManagers.findOne(userId);
            if (user!=null && user.getId()!=null) {
                result =  objToJson(achievService.findAchievementByUser(user.getId()));
            }
        }
        else {
            result = INVALID_TOKEN;
        }
        return result;
    }

    @WebMethod
    public String getAllRegions(
            @WebParam(name="sessionToken") String sessionToken) {
        initMainCfg();
        String result = "";

        if (isTokenCorrect(sessionToken))
        {
            result =  objToJson(regionService.findAll());
        }
        else {
            result = INVALID_TOKEN;
        }
        return result;
    }


    public WebServiceMain(GenericXmlApplicationContext context)
    {
        ctx = context;
        initMainCfg();
    }

    private void initMainCfg()
    {
        initContext();
        initService();
    }

    private void initContext()
    {
        if (ctx == null) {
            BasicConfigurator.configure();
            ctx = new GenericXmlApplicationContext();
            ctx.load("classpath:spring-config.xml");
            ctx.refresh();
        }
    }

    private void initService()
    {
        if (ctx!=null) {
            regionManagers = ctx.getBean(RegionManagers.class);
            sessionManagers = ctx.getBean(SessionManagers.class);
            usersManagers = ctx.getBean(UsersManagers.class);


            if (userService == null) userService = new UsersService(ctx);
            if (sessionService == null) sessionService = new SessionService(ctx);
            if (regionService == null) regionService = new RegionService(ctx);
            if (achievService == null) achievService = new AchievService(ctx);
            if (achievTypeService == null) achievTypeService = new AchievTypeService(ctx);
            if (autoService == null) autoService = new AutoService(ctx);
            if (messageService == null) messageService = new MessageService(ctx);
            if (messageTypeService == null) messageTypeService = new MessageTypeService(ctx);
            if (requestService == null) requestService = new RequestService(ctx);
            if (toolService == null) toolService = new ToolService(ctx);
            if (toolTypeService == null) toolTypeService = new ToolTypeService(ctx);
            if (trTypeService == null) trTypeService = new TrTypeService(ctx);
        }
    }

    private boolean isTokenCorrect(String sessionToken)
    {
        boolean isCorrectToken  = false;

        if (sessionService == null) {
            isCorrectToken = false;
        }
        Session session = null;
        if (sessionService != null) {
            session = sessionService.findSessionByToken(sessionToken);
        }

        if (session != null && session.getUserByUser() != null) {
            isCorrectToken = true;
        } else {
            isCorrectToken = false;
        }
        return isCorrectToken;
    }

    private User getUserByToken(String sessionToken)
    {
        User user  = null;
        if (sessionService == null) {
            user = null;
        }
        Session session = null;
        if (sessionService != null) {
            session = sessionService.findSessionByToken(sessionToken);
        }
        if (session != null) {
           user = session.getUserByUser();
        }
        return user;
    }
}
