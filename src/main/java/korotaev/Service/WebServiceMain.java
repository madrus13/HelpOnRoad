package korotaev.Service;

import korotaev.Managers.User.UsersManagers;
import korotaev.Entity.User;
import org.apache.log4j.BasicConfigurator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ejb.Stateless;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebService
@Stateless
public class WebServiceMain {
    private  static String INVALID_TOKEN =      "INVALID TOKEN";
    private  static String INVALIDE_DATA =      "INVALID DATA";
    private GenericXmlApplicationContext ctx;

    public UsersManagers service;

        private   String saveUserAndRetJson(User user)
        {
            try {
                service = ctx.getBean(UsersManagers.class);
                if (service!=null) {
                    service.save(user);
                }
           }
           catch (Exception ex) {
               ex.printStackTrace();
               return INVALIDE_DATA;
            }
            return objToJson(user);
        }

        private String objToJson(Object obj)
        {
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
        public String insertUser(String name, String region,String password)
        {
            User user = new User();
            user.setName(name);
            user.setModifyDate(Timestamp.valueOf("2018-04-15 13:29:00") );
            user.setPassword(password);
            //user.setRegion(region);

            return saveUserAndRetJson(user);
        }

    /*
            public String getUsers(String xml)
                    {
                      UsersManagers service = ctx.getBean(UsersManagers.class);




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
        List<User> find = service.findUsersByName(name);
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
    public WebServiceMain() {
        BasicConfigurator.configure();
        ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-config.xml");
        ctx.refresh();
    }
}
