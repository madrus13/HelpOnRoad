package ru.Service;

import org.joda.time.DateTime;
import ru.Entity.*;
import ru.Service.WSUtility;
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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.soap.MTOM;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import static ru.Entity.Requesttype.TypeAccumIsDown;
import static ru.Service.WSUtility.*;
import javax.jws.WebService;

@WebService
@Transactional
@MTOM(enabled = true, threshold = 102400)
public class WebServiceMain {



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

    private ServiceResult saveUserAndRetJson(User user) {
        ServiceResult res = new ServiceResult();

        try {
            usersManagers = ctx.getBean(UsersManagers.class);
            if (usersManagers != null) {
                usersManagers.save(user);
                res.IsSuccess = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            res.errorMessage = INVALIDE_DATA;
            res.IsSuccess = false;
            return res;
        }
        return objToJson(user);
    }


    private ServiceResult saveRequestAndRetJson(Request obj) {
        ServiceResult res = new ServiceResult();
        try {
            requestManagers = ctx.getBean(RequestManagers.class);
            if (requestManagers != null) {
                requestManagers.save(obj);
                res.IsSuccess = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            res.errorMessage = INVALIDE_DATA;
            res.IsSuccess = false;
            return res;
        }
        return objToJson(obj);
    }


    private ServiceResult saveMessageAndRetJson(Message obj) {
        ServiceResult res = new ServiceResult();
        try {
            messageManagers = ctx.getBean(MessageManagers.class);
            if (messageManagers != null) {
                messageManagers.save(obj);
                res.IsSuccess = true;
            }
        } catch (Exception ex) {
            res.errorMessage = INVALIDE_DATA;
            res.IsSuccess = false;
            return res;
        }
        return objToJson(obj);
    }



    @WebMethod()
    public ServiceResult insertUpdateUser(
                            @WebParam(name="Id")   Long Id,
                            @WebParam(name="sessionToken")  String sessionToken,
                            @WebParam(name="name")   String name,
                            @WebParam(name="region") Long region,
                            @WebParam(name="password") String password,
                            @WebParam(name="email") String email,
                            @WebParam(name="fileName")@XmlElement(required=false, nillable=true, name="fileName")      String fileName,
                            @WebParam(name="fileImage")@XmlElement(required=false, nillable=true, name="fileImage")      byte[] fileImage
                            ) {
        String fullPath = "";
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        User user = null;
        initMainCfg();

        if (name.isEmpty() || password.isEmpty()) {
            result.IsSuccess = false;
            result.errorMessage = INVALID_USERNAME_OR_PASS;
            return result;
        }

        CustomObjResult res = isTokenCorrectWithUser(sessionToken);

        if (Id > 0 && !sessionToken.isEmpty() && res.isBoolVal == false) {
            result.IsSuccess = false;
            result.errorMessage = INVALID_TOKEN;
            return result;
        }

        if (Id > 0 && !sessionToken.isEmpty() && !res.userId.equals(Id))
        {
            result.IsSuccess = false;
            result.errorMessage = INVALID_TOKEN_OR_USER_ID;
            return result;
        }


        User findedUser  = userService.findOneUserByName(name);

        //По имени не найден пользователь, который обновляется
        if (Id > 0 && !sessionToken.isEmpty() && findedUser == null) {
            result.IsSuccess = false;
            result.errorMessage = INVALID_USERNAME_OR_PASS;
            return result;
        }

        //Проверка имени на повтор
        if (Id <= 0 && sessionToken.isEmpty() && !name.isEmpty()) {

            if (findedUser == null) {
                user = new User();
            }
            else {
                result.IsSuccess = false;
                result.errorMessage = INVALID_USERNAME_OR_PASS;
                return result;
            }
        }

        //
        if (user == null && findedUser!=null && findedUser.getId() == Id && res.isBoolVal == true) {
            user = findedUser;
        }
        else {
            if(user==null) {
                result.IsSuccess = false;
                result.errorMessage = INVALID_TOKEN_OR_USER_ID;
                return result;

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
            if (WSUtility.saveByteToFile(fileImage, fullPath) == true) {
                user.setUserPhotoPath(fullPath);
            }
            user.setRegion(region);

            result = saveUserAndRetJson(user);
            return result;
        }
        result.IsSuccess = false;
        result.errorMessage =  INVALIDE_DATA;
        return result;
    }

    @WebMethod()
    public ServiceResult insertUpdateRequest(
            @WebParam(name="Id") @XmlElement(required=false, nillable=true, name="Id")               Long Id,
            @WebParam(name="sessionToken")      String sessionToken,
            @WebParam(name="description")       String description,
            @WebParam(name="latitude")          Double latitude,
            @WebParam(name="longitude")         Double longitude,
            @WebParam(name="statusId")          Long statusId,
            @WebParam(name="isResolvedByUser")  Long isResolvedByUserId,
            @WebParam(name="typeId")            Long typeId,
            @WebParam(name="regionId")          Long regionId,
            @WebParam(name="fileName")@XmlElement(required=false, nillable=true, name="fileName")          String fileName,
            @WebParam(name="fileImage")@XmlElement(required=false, nillable=true, name="fileImage")         byte[] fileImage

    ) {
        initMainCfg();
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;

        String resultStr = "";
        Request request = null;

        String fileDirName = "";
        CustomObjResult res = isTokenCorrectWithUser(sessionToken);
        Long createUserByToken = res.userId;
        if (res.isBoolVal == true)
        {
            List<Request > activeReqList  =
                    requestService.findRequestByCreationUserAndStatus(createUserByToken,Requeststatus.StatusOpen );
            if (!activeReqList.isEmpty())
            {
                result.errorMessage = INVALIDE_ACTIVE_REQ;
            }

            if (createUserByToken > 0) {

                if (Id > 0) {
                    Request findedRequest = requestManagers.findOne(Id);
                    if (findedRequest.getCreationUser() == createUserByToken) {
                        request = findedRequest;
                    }
                    else {
                        result.errorMessage = INVALID_TOKEN_OR_USER_ID;
                    }
                }
                else {
                    request = new Request();
                    request.setCreationDate(new Timestamp(System.currentTimeMillis()));
                    request.setCreationUser(createUserByToken);
                }

                if (request!=null) {

                    if (isResolvedByUserId > 0) {
                        User findedUser = usersManagers.findOne(isResolvedByUserId);

                        if (findedUser!=null) {
                            request.setResolvedByUser(isResolvedByUserId);
                            //Id юзера создавшего запрос - совпадает с юзером который запрос разрешил
                            if (isResolvedByUserId == createUserByToken) {
                                request.setIsResolvedByUser((byte)1);
                                request.setStatus(Requeststatus.StatusClose);
                            }
                        }
                        result = saveRequestAndRetJson(request);
                        return result;
                    }

                    if (description.isEmpty() == false) {
                        request.setDescription(description);
                    }

                    if (latitude!=0L && longitude!=0L) {
                        request.setLatitude(latitude);
                        request.setLongitude(longitude);
                    }

                    request.setModifyDate(new Timestamp(System.currentTimeMillis()));
                    if ((statusId == Requeststatus.StatusOpen) || (statusId == Requeststatus.StatusClose))
                    {
                        request.setStatus(statusId);
                    }
                    if (    typeId == Requesttype.TypeAccumIsDown ||
                            typeId == Requesttype.TypeNotStarted ||
                            typeId == Requesttype.TypeStuck ||
                            typeId == Requesttype.TypeAlarm ||
                            typeId == Requesttype.TypeCarNotOpen ||
                            typeId == Requesttype.TypeTowTruckNeed
                            ) {
                        request.setType(typeId);
                    }
                    if (regionId > 0) {
                        request.setRegion(regionId);
                    }
                    if (!fileName.isEmpty()) {
                        fileDirName = F_WEB_FILES_REQUEST_PHOTO + String.valueOf(request.hashCode()) + System.currentTimeMillis() + fileName;
                        if (saveByteToFile(fileImage, fileDirName) == true) {
                            request.setRequestPhotoPath(fileDirName);
                        }
                    }

                    result = saveRequestAndRetJson(request);
                    return result;
                }
                else {
                    result.errorMessage = INVALIDE_DATA;
                }

            }
        }
        else {
            result.errorMessage =  INVALID_TOKEN;
        }

        return result;
    }




    @WebMethod
    public ServiceResult getSessionToken(
            @WebParam(name="name") String name,
            @WebParam(name="password") String password)
    {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        //result.errorMessage = INVALIDE_DATA;

        User user = null;
        Session findSession = null;

        initMainCfg();
        user = userService.findOneUserByName(name);
        if (user !=null && user.getPassword().equals(password))
        {
            findSession = sessionService.findSessionByUserId(user.getId());

            if (findSession !=null && findSession.getToken().equals("")) {
                result.ResultObjectJSON =  findSession.getToken();
                result.IsSuccess = true;
            }
            else {
                if (user!=null) {
                    ru.Entity.Session newSession = new ru.Entity.Session();
                    newSession.setUser(user.getId());
                    newSession.setToken(WSUtility.generateHash(user.getName()+user.getPassword()+ DateTime.now().toString()));
                    sessionManagers.save(newSession);
                    result = objToJson(newSession);
                }
            }
        }

        return result;
    }


    @WebMethod()
    public ServiceResult insertMessage(
            @WebParam(name="Id")            Long Id,
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="text")          String text,
            @WebParam(name="requestId")     Long requestId,
            @WebParam(name="regionId")      Long regionId,
            @WebParam(name="userRx")        Long userRx,
            @WebParam(name="typeId")        Long typeId,
            @WebParam(name="fileName")      String fileName,
            @WebParam(name="fileImage")     byte[] fileImage

    ) {
        initMainCfg();
        Message msg = null;
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;

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
                        result.IsSuccess = false;
                        result.errorMessage = INVALID_TOKEN_OR_USER_ID;
                        return result;
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
                    if (userRx > 0){
                        msg.setUserRx(userRx);
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
                    result.IsSuccess = false;
                    result.errorMessage = INVALIDE_DATA;
                }
            }
        }
        else {
            result.IsSuccess = false;
            result.errorMessage = INVALID_TOKEN;
        }

        return result;
    }

    @WebMethod
    public ServiceResult getMessageByRegionAndIdGreater(
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="regionId")      Long regionId,
            @WebParam(name="lastId")        Long lastId,
            @WebParam(name="pageSize")      int pageSize

            ) {
        initMainCfg();
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;

        if (isTokenCorrect(sessionToken))
        {
            result = objToJson(messageService.findMessageByRegionAndAndIdAfter(regionId, lastId,pageSize ));
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        return result;
    }


    @WebMethod
    public ServiceResult getAllMessageByRequest(
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="request")       Long request,
            @WebParam(name="pageSize")      int pageSize

    ) {
        initMainCfg();
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;

        if (isTokenCorrect(sessionToken))
        {
            result=  objToJson(messageService.findAllMessageByRequest(request,pageSize ));

        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        return result;
    }

    @WebMethod
    public ServiceResult getAllRequestByCreationUser(
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="userId")        Long userId
    ) {
        initMainCfg();
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;

        if (isTokenCorrect(sessionToken))
        {
            result =   objToJson(requestService.findRequestByCreationUser(userId ));
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        return result;
    }


    @WebMethod
    public ServiceResult getActiveRequestByCreationUser(
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="userId")        Long userId
    ) {
        initMainCfg();
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;

        if (isTokenCorrect(sessionToken))
        {
            result = objToJson(requestService.findRequestByCreationUserAndStatus(userId,Requeststatus.StatusOpen ));
            result.IsSuccess = true;
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        return result;
    }

    @WebMethod
    public ServiceResult getAllOpenRequestByRegion(
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="regionId")        Long regionId,
            @WebParam(name="typeIds") @XmlElement(required=false, nillable=true, name="typeIds")       String typeIds

    ) {
        initMainCfg();
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;

        List<Long> listTypeIds = null;
        if (isTokenCorrect(sessionToken))
        {
            if (typeIds.length() <= 0) {
                result = objToJson(requestService.findRequestByRegionAndStatus(regionId, Requeststatus.StatusOpen ));
            }
            else {
                if (typeIds.length() > 0) {
                    listTypeIds = Arrays.stream(typeIds.split(",")).map(Long::parseLong).collect(Collectors.toList());
                }
                result = objToJson(requestService.findRequestByRegionAndStatusAndTypeIn(regionId, Requeststatus.StatusOpen,listTypeIds ));
                result.IsSuccess = true;
            }
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        return result;
    }

    @WebMethod
    public ServiceResult findRequestResolvedByCurrentUserWithTypeFilter(
            @WebParam(name="sessionToken")   String sessionToken,
            @WebParam(name="typeIds") @XmlElement(required=false, nillable=true, name="typeIds")       String typeIds
    ) {
        initMainCfg();
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        List<Long> listTypeIds = null;

        CustomObjResult res = isTokenCorrectWithUser(sessionToken);

        if (res.isBoolVal && res.userId > 0)
        {
            if (typeIds.isEmpty()) {
                result = objToJson(requestService.findRequestByResolvedByUserAndStatus(
                        res.userId, Requeststatus.StatusClose ));
                result.IsSuccess = true;
            }
            else {

                    if (typeIds.length() > 0) {
                        listTypeIds = Arrays.stream(typeIds.split(",")).map(Long::parseLong).collect(Collectors.toList());
                    }

                    if (!listTypeIds.isEmpty())
                    {
                        result = objToJson(requestService.findRequestByResolvedByUserAndStatusAndTypeIn(
                                res.userId, Requeststatus.StatusClose,listTypeIds ));
                    }
                }
            }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        return result;
    }

    @WebMethod
    public ServiceResult getUserInfo(
            @WebParam(name="sessionToken") String sessionToken) {
        initMainCfg();
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;

        if (isTokenCorrect(sessionToken))
        {
            Session session = null;
            if (sessionService != null) {
                session = sessionService.findSessionByToken(sessionToken);
            }
            result = objToJson(session.getUserByUser());
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        return result;
    }

    @WebMethod
    public ServiceResult getAllMessageTypes(
            @WebParam(name="sessionToken") String sessionToken) {
        initMainCfg();
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;

        if (isTokenCorrect(sessionToken))
        {
            result = objToJson(messageTypeService.findAll());
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        return result;
    }

    @WebMethod
    public ServiceResult getAllRequestType(
            @WebParam(name="sessionToken") String sessionToken) {
        initMainCfg();
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;

        if (isTokenCorrect(sessionToken))
        {
            result = objToJson(requestTypeService.findAll());
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        return result;
    }

    @WebMethod
    public ServiceResult getAllTransmissionType(
            @WebParam(name="sessionToken") String sessionToken) {
        initMainCfg();
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;

        if (isTokenCorrect(sessionToken))
        {
            result  = objToJson(trTypeService.findAll());
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        return result;
    }

    @WebMethod
    public ServiceResult getAllToolType(
            @WebParam(name="sessionToken") String sessionToken) {
        initMainCfg();
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;

        if (isTokenCorrect(sessionToken))
        {
            result = objToJson(toolTypeService.findAll());
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        return result;
    }

    @WebMethod
    public ServiceResult getAllAchievmenttype(
            @WebParam(name="sessionToken") String sessionToken) {
        initMainCfg();
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;

        if (isTokenCorrect(sessionToken))
        {
            result = objToJson(achievTypeService.findAll());
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        return result;
    }


    @WebMethod
    public ServiceResult getAllAchievmentByUser(
            @WebParam(name="sessionToken") String sessionToken,
            @WebParam(name="user") Long userId) {
        initMainCfg();
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;

        User user = null;
        List<Achievement> achievs = null;
        if (isTokenCorrect(sessionToken))
        {
            user = usersManagers.findOne(userId);
            if (user!=null && user.getId()!=null) {
                result = objToJson(achievService.findAchievementByUser(user.getId()));
            }
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        return result;
    }


    @WebMethod
    public ServiceResult getAllToolByUser(
            @WebParam(name="sessionToken") String sessionToken,
            @WebParam(name="user") Long userId) {
        initMainCfg();
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;

        User user = null;
        List<Tool> achievs = null;
        if (isTokenCorrect(sessionToken))
        {
            user = usersManagers.findOne(userId);
            if (user!=null && user.getId()!=null) {
                result = objToJson(toolService.findToolByUser(user.getId()));
            }
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        return result;
    }


    @WebMethod
    public ServiceResult getAllAutoByUser(
            @WebParam(name="sessionToken") String sessionToken,
            @WebParam(name="user") Long userId) {
        initMainCfg();

        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;

        User user = null;
        List<Tool> tools = null;
        if (isTokenCorrect(sessionToken))
        {
            user = usersManagers.findOne(userId);
            if (user!=null && user.getId()!=null) {
                result = objToJson(autoService.findAutoByUser(user.getId()));
            }
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        return result;
    }


    @WebMethod
    public ServiceResult getAllRegions(
            @WebParam(name="sessionToken") String sessionToken) {
        initMainCfg();

        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;

        if (isTokenCorrect(sessionToken))
        {
            result = objToJson(regionService.findAll());
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
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
