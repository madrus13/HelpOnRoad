package ru.Service;

import org.joda.time.DateTime;
import ru.Entity.*;
import ru.Managers.Achievement.AchievService;
import ru.Managers.Achievmenttype.AchievTypeService;
import ru.Managers.Auto.AutoService;
import ru.Managers.Message.MessageManagers;
import ru.Managers.Message.MessageService;
import ru.Managers.Messagetype.MessageTypeService;
import ru.Managers.Region.RegionManagers;
import ru.Managers.Region.RegionService;
import ru.Managers.Request.RequestManagers;
import ru.Managers.Request.RequestService;
import ru.Managers.Requesttype.RequestTypeService;
import ru.Managers.Session.SessionManagers;
import ru.Managers.Session.SessionService;
import ru.Managers.Tool.ToolService;
import ru.Managers.Tooltypes.ToolTypeService;
import ru.Managers.Transmissiontype.TrTypeService;
import ru.Managers.User.UsersManagers;
import ru.Managers.User.UsersService;
import org.apache.log4j.BasicConfigurator;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.List;

class CustomObjResult{
    public Long userId;
    public boolean isBoolVal;

    public CustomObjResult(Long id, boolean isBoolVal) {
        this.userId = id;
        this.isBoolVal = isBoolVal;
    }



}

@WebService
@Transactional
@MTOM(enabled = true, threshold = 102400)
public class WebServiceMain {

    private static final String F_WEB_FILES_REQUEST_PHOTO = "f:\\WebFiles\\RequestPhoto\\";
    private static final String F_WEB_FILES_USER_AVATAR_PHOTO = "f:\\WebFiles\\UserAvatarPhoto\\";
    private static final String F_WEB_FILES_MESSAGE_PHOTO = "f:\\WebFiles\\MessagePhoto\\";

    private static final String INVALID_USERNAME_OR_PASS = "INVALID_USERNAME_OR_PASS";
    private static final String INVALID_TOKEN = "INVALID TOKEN";
    private static final String INVALID_TOKEN_OR_USER_ID = "INVALID_TOKEN_OR_USER_ID";
    private static final String INVALIDE_DATA = "INVALID DATA";

    private GenericXmlApplicationContext ctx;

    private UsersManagers usersManagers;
    private RegionManagers regionManagers;
    private SessionManagers sessionManagers;
    private RequestManagers requestManagers;
    private MessageManagers messageManagers;

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


    private String saveRequestAndRetJson(Request obj) {
        try {
            requestManagers = ctx.getBean(RequestManagers.class);
            if (requestManagers != null) {
                requestManagers.save(obj);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return INVALIDE_DATA;
        }
        return objToJson(obj);
    }


    private String saveMessageAndRetJson(Message obj) {
        try {
            messageManagers = ctx.getBean(MessageManagers.class);
            if (messageManagers != null) {
                messageManagers.save(obj);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return INVALIDE_DATA;
        }
        return objToJson(obj);
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
    public String insertUpdateUser(
                            @WebParam(name="Id")   Long Id,
                            @WebParam(name="sessionToken")  String sessionToken,
                            @WebParam(name="name")   String name,
                            @WebParam(name="region") Long region,
                            @WebParam(name="password") String password,
                            @WebParam(name="email") String email,
                            @WebParam(name="fileName")      String fileName,
                            @WebParam(name="fileImage")     byte[] fileImage
                            ) {
        String fullPath = "";
        User user = null;
        initMainCfg();

        if (name.isEmpty() || password.isEmpty()) {
            return INVALID_USERNAME_OR_PASS;
        }

        CustomObjResult res = isTokenCorrectWithUser(sessionToken);

        if (Id > 0 && !sessionToken.isEmpty() && res.isBoolVal == false) {
            return INVALID_TOKEN;
        }

        if (Id > 0 && !sessionToken.isEmpty() && !res.userId.equals(Id))
        {
            return INVALID_TOKEN_OR_USER_ID;
        }


        User findedUser  = userService.findOneUserByName(name);

        //По имени не найден пользователь, который обновляется
        if (Id > 0 && !sessionToken.isEmpty() && findedUser == null) {
            return INVALID_USERNAME_OR_PASS;
        }

        //Проверка имени на повтор
        if (Id <= 0 && sessionToken.isEmpty() && !name.isEmpty()) {

            if (findedUser == null) {
                user = new User();
            }
            else {
                return INVALID_USERNAME_OR_PASS;
            }
        }

        //
        if (user == null && findedUser!=null && findedUser.getId() == Id && res.isBoolVal == true) {
            user = findedUser;
        }
        else {
            if(user==null) {
                return INVALID_TOKEN_OR_USER_ID;
            }
        }



        if (user  != null) {
            user.setName(name);
            user.setCreationDate(new Timestamp(System.currentTimeMillis()));
            user.setModifyDate(new Timestamp(System.currentTimeMillis()));
            user.setPassword(password);
            user.setEmail(email);
            user.setStatus(Userstatus.StatusCommon); //Const : common user

            fullPath = F_WEB_FILES_USER_AVATAR_PHOTO + String.valueOf(user.hashCode()) + System.currentTimeMillis() + fileName;
            if (saveByteToFile(fileImage, fullPath) == true) {
                user.setUserPhotoPath(fullPath);
            }
            user.setRegion(region);
            return saveUserAndRetJson(user);
        }

    return INVALIDE_DATA;
    }

    @WebMethod()
    public String insertUpdateRequest(
            @WebParam(name="Id")            Long Id,
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="name")          String name,
            @WebParam(name="description")   String description,
            @WebParam(name="latitude")      double latitude,
            @WebParam(name="longitude")     double longitude,
            @WebParam(name="statusId")      Long statusId,
            @WebParam(name="typeId")        Long typeId,
            @WebParam(name="fileName")      String fileName,
            @WebParam(name="fileImage")     byte[] fileImage

    ) {
        initMainCfg();
        String result = "";
        Request request = null;

        String fileDirName = "";
        CustomObjResult res = isTokenCorrectWithUser(sessionToken);
        Long createUserByToken = res.userId;
        if (res.isBoolVal == true)
        {
            if (createUserByToken > 0) {

                if (Id > 0) {
                    Request findedRequest = requestManagers.findOne(Id);
                    if (findedRequest.getCreationUser() == createUserByToken) {
                        request = findedRequest;
                    }
                    else {
                        return INVALID_TOKEN_OR_USER_ID;
                    }
                }
                else {
                    request = new Request();
                    request.setCreationDate(new Timestamp(System.currentTimeMillis()));
                }

                if (request!=null) {
                    request.setDescription(description);
                    request.setLatitude(latitude);
                    request.setLongitude(longitude);
                    request.setModifyDate(new Timestamp(System.currentTimeMillis()));
                    if ((statusId == Requeststatus.StatusOpen) || (statusId == Requeststatus.StatusClose))
                    {
                        request.setStatus(statusId);
                    }

                    request.setType(typeId);
                    request.setCreationUser(createUserByToken);
                    fileDirName = F_WEB_FILES_REQUEST_PHOTO + String.valueOf(request.hashCode()) + System.currentTimeMillis() + fileName;
                    if (saveByteToFile(fileImage, fileDirName) == true) {
                        request.setRequestPhotoPath(fileDirName);
                    }
                    result = saveRequestAndRetJson(request);
                }
                else {
                    result = INVALIDE_DATA;
                }

            }
        }
        else {
            result = INVALID_TOKEN;
        }

        return result;
    }

    private boolean saveByteToFile(byte[] fileImage, String fullPathToSave)
    {
        byte[] encodedBytes;
        boolean isSuccess = false;
        if (fileImage!=null && fileImage.length > 0) {
            encodedBytes = Base64.getEncoder().encode(fileImage);

            try (FileOutputStream fos = new FileOutputStream(  fullPathToSave )) {
                fos.write(encodedBytes);
                isSuccess = true;
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return isSuccess;
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


    @WebMethod()
    public String insertMessage(
            @WebParam(name="Id")            Long Id,
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="text")          String text,
            @WebParam(name="requestId")     Long requestId,
            @WebParam(name="regionId")      Long regionId,
            @WebParam(name="typeId")        Long typeId,
            @WebParam(name="fileName")      String fileName,
            @WebParam(name="fileImage")     byte[] fileImage

    ) {
        initMainCfg();
        String result = "";
        Message msg = null;

        String fileDirName = "";
        CustomObjResult res = isTokenCorrectWithUser(sessionToken);
        Long createUserByToken = res.userId;
        if (res.isBoolVal == true)
        {
            if (createUserByToken > 0) {

                if (Id > 0) {
                    Message findedMsg = messageManagers.findOne(Id);
                    if (findedMsg.getCreateUser() == createUserByToken) {
                        msg = findedMsg;
                    }
                    else {
                        return INVALID_TOKEN_OR_USER_ID;
                    }
                }
                else {
                    msg = new Message();
                    msg.setCreationDate(new Timestamp(System.currentTimeMillis()));
                }

                if (msg!=null) {
                    msg.setModifyDate(new Timestamp(System.currentTimeMillis()));

                    if (regionId > 0){
                        msg.setRegion(regionId);
                    }
                    if (requestId > 0){
                        msg.setRequest(requestId);
                    }
                    if (typeId > 0){
                        msg.setType(typeId);
                    }
                    msg.setText(text);
                    msg.setCreateUser(createUserByToken);
                    fileDirName = F_WEB_FILES_MESSAGE_PHOTO + String.valueOf(msg.hashCode()) + System.currentTimeMillis() + fileName;
                    if (saveByteToFile(fileImage, fileDirName) == true) {
                        msg.setMessagePhotoPath(fileDirName);
                    }
                    result = saveMessageAndRetJson(msg);
                }
                else {
                    result = INVALIDE_DATA;
                }
            }
        }
        else {
            result = INVALID_TOKEN;
        }

        return result;
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
    public String getAllAchievmenttype(
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
    public String getAllAchievmentByUser(
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
    public String getAllToolByUser(
            @WebParam(name="sessionToken") String sessionToken,
            @WebParam(name="user") Long userId) {
        initMainCfg();
        String result = "";
        User user = null;
        List<Tool> achievs = null;
        if (isTokenCorrect(sessionToken))
        {
            user = usersManagers.findOne(userId);
            if (user!=null && user.getId()!=null) {
                result =  objToJson(toolService.findToolByUser(user.getId()));
            }
        }
        else {
            result = INVALID_TOKEN;
        }
        return result;
    }


    @WebMethod
    public String getAllAutoByUser(
            @WebParam(name="sessionToken") String sessionToken,
            @WebParam(name="user") Long userId) {
        initMainCfg();
        String result = "";
        User user = null;
        List<Tool> tools = null;
        if (isTokenCorrect(sessionToken))
        {
            user = usersManagers.findOne(userId);
            if (user!=null && user.getId()!=null) {
                result =  objToJson(autoService.findAutoByUser(user.getId()));
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
            requestManagers = ctx.getBean(RequestManagers.class);
            messageManagers = ctx.getBean(MessageManagers.class);

            if (userService == null) userService = new UsersService(ctx);
            if (sessionService == null) sessionService = new SessionService(ctx);
            if (regionService == null) regionService = new RegionService(ctx);
            if (achievService == null) achievService = new AchievService(ctx);
            if (achievTypeService == null) achievTypeService = new AchievTypeService(ctx);
            if (autoService == null) autoService = new AutoService(ctx);
            if (messageService == null) messageService = new MessageService(ctx);
            if (messageTypeService == null) messageTypeService = new MessageTypeService(ctx);
            if (requestService == null) requestService = new RequestService(ctx);
            if (requestTypeService == null) requestTypeService = new RequestTypeService(ctx);
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

    private CustomObjResult isTokenCorrectWithUser(String sessionToken)
    {
        CustomObjResult res = null;
        boolean isCorrectToken  = false;
        Long outUserId = -1L;

        if (sessionService == null) {
            isCorrectToken = false;
        }
        Session session = null;
        if (sessionService != null) {
            session = sessionService.findSessionByToken(sessionToken);
        }

        if (session != null && session.getUserByUser() != null) {
            isCorrectToken = true;
            outUserId = session.getUser();
        } else {
            isCorrectToken = false;
        }
        res = new CustomObjResult(outUserId, isCorrectToken);
        return res;
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
