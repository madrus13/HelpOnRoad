package korotaev.Service;

import korotaev.Entity.Session;
import korotaev.Entity.TransmissionType;
import korotaev.Managers.Achievement.AchievService;
import korotaev.Managers.Achievmenttype.AchievTypeService;
import korotaev.Managers.Auto.AutoService;
import korotaev.Managers.Message.MessageService;
import korotaev.Managers.Messagetype.MessageTypeService;
import korotaev.Managers.Region.RegionService;
import korotaev.Managers.Request.RequestService;
import korotaev.Managers.Session.SessionService;
import korotaev.Managers.Tool.ToolService;
import korotaev.Managers.Tooltypes.ToolTypeService;
import korotaev.Managers.Transmissiontype.TrTypeService;
import korotaev.Managers.User.UsersManagers;
import korotaev.Entity.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ejb.Stateless;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

@WebService
@Stateless
public class WebServiceMain {
    private static String INVALID_TOKEN = "INVALID TOKEN";
    private static String INVALIDE_DATA = "INVALID DATA";
    private GenericXmlApplicationContext ctx;

    private UsersManagers usersManagers;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    @WebMethod
    public String insertUser(String name, String region, String password) {
        User user = new User();
        user.setName(name);
        user.setCreationDate(new Timestamp(System.currentTimeMillis()));
        user.setCreationDate(new Timestamp(System.currentTimeMillis()));
        user.setPassword(password);
        //user.setRegion(region);

        return saveUserAndRetJson(user);
    }


    public String sha1(String s) {
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
    /*
    @WebMethod
    public String getSessionToken(String name, String password)
    {
        String res = INVALIDE_DATA;
        List<User> find = usersManagers.findUsersByName(name);
        User model = null;

        if (find.isEmpty() == false) {
            model = find.get(0);

        }
        if (model!=null && model.getPassword() == password) {
            findSession = TSession::find()->where(['User' => $model->Id]);

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



                public function getUserInfo($sessionToken)
                        {
                                $userId = $this->getUserIdByToken($sessionToken);
                if ($userId == null) {
                    return INVALID_TOKEN;
                }

                $user = Tuser::findAll(['Id' => $userId]);

                if ($user!=null)
                {
                    return   BaseJson::encode($user);
                }
                return INVALIDE;
            }



                public function getAllMessageTypes($sessionToken)
                        {
                                $userId = $this->getUserIdByToken($sessionToken);
                if ($userId == null) {
                    return INVALID_TOKEN;
                }

                $types = Tmessagetype::find()->all();

                if ($types!=null)
                {
                    return   BaseJson::encode($types);
                }
                return INVALIDE;
            }



                public function getAllRequestType($sessionToken)
                        {
                                $userId = $this->getUserIdByToken($sessionToken);
                if ($userId == null) {
                    return INVALID_TOKEN;
                }

                $types = TRequestType::find()->all();

                if ($types!=null)
                {
                    return   BaseJson::encode($types);
                }
                return INVALIDE;
            }



                public function getAllTransmissionType($sessionToken)
                        {
                                $userId = $this->getUserIdByToken($sessionToken);
                if ($userId == null) {
                    return INVALID_TOKEN;
                }

                $types = Ttransmissiontype::find()->all();

                if ($types!=null)
                {
                    return   BaseJson::encode($types);
                }
                return INVALIDE;
            }


                public function getAllToolType($sessionToken)
                        {
                                $userId = $this->getUserIdByToken($sessionToken);
                if ($userId == null) {
                    return INVALID_TOKEN;
                }

                $types = Ttooltypes::find()->all();

                if ($types!=null)
                {
                    return   BaseJson::encode($types);
                }
                return INVALIDE;
            }


                public function getAllTachievmenttype($sessionToken)
                        {
                                $userId = $this->getUserIdByToken($sessionToken);
                if ($userId == null) {
                    return INVALID_TOKEN;
                }

                $types = Tachievmenttype::find()->all();

                if ($types!=null)
                {
                    return   BaseJson::encode($types);
                }
                return INVALIDE;
            }

             */
    @WebMethod
    public String getAllRegions(String $sessionToken) {
        String result = "";
        if (sessionService == null) {
            result = "Not inited";
        }
        Session session = sessionService.findSessionByToken($sessionToken);

        if (session != null && session.getUserByUser() != null) {

        } else {
            result = INVALID_TOKEN;
        }
        result =  objToJson(regionService.findAll());

        return result;
    }
    /*
    }


            public function getAllRegions($sessionToken)
                    {
                            $userId = $this->getUserIdByToken($sessionToken);
            if ($userId == null) {
                return INVALID_TOKEN;
            }

            $types = Tregion::find()->all();

            if ($types!=null)
            {
                return   BaseJson::encode($types);
            }
            return INVALIDE;
        }
    */
    public WebServiceMain(GenericXmlApplicationContext context) {
        ctx = context;
        sessionService = new SessionService(ctx);
        regionService = new RegionService(ctx);
        achievService = new AchievService(ctx);
        achievTypeService = new AchievTypeService(ctx);
        autoService = new AutoService(ctx);
        messageService = new MessageService(ctx);
        messageTypeService = new MessageTypeService();
        requestService = new RequestService(ctx);
        toolService = new ToolService(ctx);
        toolTypeService = new ToolTypeService(ctx);
        trTypeService = new TrTypeService(ctx);
    }
}
