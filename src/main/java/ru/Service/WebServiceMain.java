package ru.Service;

import org.joda.time.DateTime;
import ru.Entity.Session;
import ru.Managers.Achievement.AchievService;
import ru.Managers.Achievmenttype.AchievTypeService;
import ru.Managers.Auto.AutoService;
import ru.Managers.Message.MessageService;
import ru.Managers.Messagetype.MessageTypeService;
import ru.Managers.Region.RegionManagers;
import ru.Managers.Region.RegionService;
import ru.Managers.Request.RequestService;
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
                            @WebParam(name="region") String region,
                            @WebParam(name="password") String password) {
        initMainCfg();
        User user = new User();
        user.setName(name);
        user.setCreationDate(new Timestamp(System.currentTimeMillis()));
        user.setModifyDate(new Timestamp(System.currentTimeMillis()));
        user.setPassword(password);
        //user.setRegion(region);

        /*
        for (int i = 0; i < 500; i++) {
            ru.Entity.Region reg = new ru.Entity.Region();
            reg.setName("name_" + i);
            regionManagers.save(reg);
        }
        */

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

    /*
            public String getUsers(String xml)
                    {
                      UsersManagers usersManagers = ctx.getBean(UsersManagers.class);




                         $jsString = BaseJson::encode($res);


            if ($jsString == null) {
                return "RESULT IS NULL";
            }

            return $jsString;
        }
*/

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
    /*
                public function getSessionToken($user, $password)
                {
                    $result = INVALID_TOKEN;
                    $find = Tuser::find()->where(['Name' => $user]);

                    $model = null;
                    if ($find!=null) {
                        $model = $find->one();
                    }
                    if ($model!=null && $model->Password == $password) {
                        $findSession = TSession::find()->where(['User' => $model->Id]);

                        if ($findSession !=null && $findSession->one()!=null) {
                            $session = $findSession->one();
                            $result =  $session->Token;
                        }
                        else {
                            if ($model!=null && $user!=null) {
                                $newSession = new TSession();
                                $newSession->User = $model->Id;
                                $newSession->Token = (string) ($user.base_convert(sha1(uniqid(mt_rand(), true)), 16, 36));
                                if(!$newSession->save())
                                    return BaseJson::encode($newSession->getErrors());
                                $result = $newSession->Token;
                            }
                        }
                    }

                    return $result;
                }


                public function getUserIdByToken($sessionToken)
                        {
                                $findSession = TSession::find()->where(['Token' => $sessionToken]);

                if ($findSession !=null && $findSession->one()!=null) {
                    $userId = $findSession->one()->User;
                    return $userId;
                }
                else {
                    return null;
                }

            }


                public function getUserAchievment($sessionToken)
                        {
                                $userId = $this->getUserIdByToken($sessionToken);
                if ($userId == null) {
                    return INVALID_TOKEN;
                }

                $val = Tachievement::findAll(['User' => $userId]);

                if ($val!=null)
                {
                    return   BaseJson::encode($val);
                }
                return $userId;
            }



                public function getUserTools($sessionToken)
                        {
                                $userId = $this->getUserIdByToken($sessionToken);
                if ($userId == null) {
                    return INVALID_TOKEN;
                }

                $val = Ttool::findAll(['User' => $userId]);

                if ($val!=null)
                {
                    return   BaseJson::encode($val);
                }
                return $userId;
            }



                public function getUserAuto($sessionToken)
                        {
                                $userId = $this->getUserIdByToken($sessionToken);
                if ($userId == null) {
                    return INVALID_TOKEN;
                }

                $auto = Tauto::findAll(['User' => $userId]);

                if ($auto!=null)
                {
                    return   BaseJson::encode($auto);
                }
                return INVALIDE;
            }


             */

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
            result =  objToJson(messageService.findAll());
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
            result =  objToJson(requestService.findAll());
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
            if (messageTypeService == null) messageTypeService = new MessageTypeService();
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
