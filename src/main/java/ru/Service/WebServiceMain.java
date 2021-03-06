package ru.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.log4j.*;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.thymeleaf.util.DateUtils;
import ru.Entity.*;
import ru.Managers.Auto.AutoManagers;
import ru.Managers.Files.FilesManagers;
import ru.Managers.Files.FilesService;
import ru.Managers.Tool.ToolManagers;
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

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.ws.soap.MTOM;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Stream.*;
import static ru.Entity.Requesttype.TypeAccumIsDown;
import static ru.Service.WSUtility.*;
import javax.jws.WebService;

@WebService
@Transactional
@MTOM(enabled = true, threshold = 102400)
public class WebServiceMain {


    private Byte isDeletedFalse = 0;
    private Byte isDeletedTrue  = 1;
    private GenericXmlApplicationContext ctx;

    private UsersManagers usersManagers;
    private RegionManagers regionManagers;
    private SessionManagers sessionManagers;
    private RequestManagers requestManagers;
    private MessageManagers messageManagers;
    private AutoManagers autoManagers;
    private ToolManagers toolsManagers;
    private FilesManagers filesManagers;



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
    private FilesService filesService;


    public static String OVERALL_TAG = "overall";
    public static String PREPARE_TAG = "prepare";
    public static String SAVE_OBJ_TAG = "saveObj";

    public  SendPushNotification sendPushNotification;
    public WebServiceMain() {
        initContext();
        initService();
    }

    private ServiceResult saveUserAndRetJson(User user) {
        ServiceResult res = new ServiceResult();
        long start = System.currentTimeMillis() % 1000;

        try {
            if (usersManagers != null) {
                usersManagers.save(user);
                res.IsSuccess = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            res.errorMessage = INVALIDE_DATA;
            res.IsSuccess = false;
            res.timingMessage += genTimeInfo(SAVE_OBJ_TAG,start);
            return res;
        }

        return objToJson(user,  genTimeInfo(SAVE_OBJ_TAG,start));
    }


    private ServiceResult saveAutoAndRetJson(Auto obj) {
        ServiceResult res = new ServiceResult();
        long start = System.currentTimeMillis() % 1000;
        try {
            if (autoManagers != null) {
                autoManagers.save(obj);
                res.IsSuccess = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            res.errorMessage = INVALIDE_DATA;
            res.IsSuccess = false;
            res.timingMessage += genTimeInfo(SAVE_OBJ_TAG,start);
            return res;
        }
        return objToJson(obj,genTimeInfo(SAVE_OBJ_TAG,start));
    }

    private ServiceResult saveToolAndRetJson(Tool obj) {
        ServiceResult res = new ServiceResult();
        long start = System.currentTimeMillis() % 1000;
        long end = start;
        try {
            if (toolsManagers != null) {
                toolsManagers.save(obj);
                res.IsSuccess = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            res.errorMessage = INVALIDE_DATA;
            res.IsSuccess = false;
            res.timingMessage += genTimeInfo(SAVE_OBJ_TAG,start);
            return res;
        }
        return objToJson(obj,genTimeInfo(SAVE_OBJ_TAG,start));
    }


    private ServiceResult saveRequestAndRetJson(Request obj) {
        ServiceResult res = new ServiceResult();
        long start = System.currentTimeMillis() % 1000;
        try {
            if (requestManagers != null) {
                requestManagers.save(obj);
                res.IsSuccess = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            res.errorMessage = INVALIDE_DATA;
            res.IsSuccess = false;
            res.timingMessage += genTimeInfo(SAVE_OBJ_TAG,start);
            return res;
        }
        return objToJson(obj,genTimeInfo(SAVE_OBJ_TAG,start));
    }


    private ServiceResult saveMessageAndRetJson(Message obj) {
        ServiceResult res = new ServiceResult();
        long start = System.currentTimeMillis() % 1000;
        try {
            if (messageManagers != null) {
                messageManagers.save(obj);
                res.IsSuccess = true;
            }
        } catch (Exception ex) {
            res.errorMessage = INVALIDE_DATA;
            res.IsSuccess = false;
            res.timingMessage += genTimeInfo(SAVE_OBJ_TAG,start);
            return res;
        }
        return objToJson(obj,genTimeInfo(SAVE_OBJ_TAG,start));
    }


    private ServiceResult saveFileAndRetJson(Files obj) {
        ServiceResult res = new ServiceResult();
        long start = System.currentTimeMillis() % 1000;
        try {
            if (filesManagers != null) {
                filesManagers.save(obj);
                res.IsSuccess = true;
            }
        } catch (Exception ex) {
            res.errorMessage = INVALIDE_DATA;
            res.IsSuccess = false;
            res.timingMessage += genTimeInfo(SAVE_OBJ_TAG,start);
            return res;
        }
        return objToJson(obj,genTimeInfo(SAVE_OBJ_TAG,start));
    }


    @WebMethod
    public ServiceResult insertUser(
            @WebParam(name="name")   String name,
            @WebParam(name="region") Long region,
            @WebParam(name="password") String password,
            @WebParam(name="email") String email,
            @WebParam(name="phone") String phone
    ) {
        String fullPath = "";
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        User user = null;
        long start = System.currentTimeMillis() % 1000;

        if (name.isEmpty() || password.isEmpty() || phone.isEmpty() ) {
            result.IsSuccess = false;
            result.errorMessage = INVALID_USERNAME_OR_PASS_OR_PHONE;
            result.timingMessage += genTimeInfo(PREPARE_TAG,start);
            return result;
        }

        User findedUserByNameOrEmail  = userService.findFirstByNameOrEmail(name, email);
        if (findedUserByNameOrEmail!=null) {
            result.IsSuccess = false;
            result.errorMessage = INVALID_USERNAME_OR_EMAIL;
            result.timingMessage += genTimeInfo(PREPARE_TAG,start);
            return result;
        }

        if (findedUserByNameOrEmail == null) {
            user = new User();
        }
        else {
            result.IsSuccess = false;
            result.errorMessage = INVALID_USERNAME_OR_PASS_OR_PHONE;
            result.timingMessage += genTimeInfo(PREPARE_TAG,start);
            return result;
        }

        if (user  != null) {
            user.setIsDeleted(isDeletedFalse);
            user.setName(name);
            user.setPhone(phone);
            user.setCreationDate(new Timestamp(System.currentTimeMillis()));
            user.setModifyDate(new Timestamp(System.currentTimeMillis()));
            user.setPassword(password);
            user.setEmail(email);
            user.setStatus(Userstatus.StatusCommon); //Const : common user
            if (region > 0) {
                user.setRegion(region);
            }

            result = saveUserAndRetJson(user);
            result.timingMessage += genTimeInfo(PREPARE_TAG,start);
            return result;
        }
        result.IsSuccess = false;
        result.errorMessage =  INVALIDE_DATA;
        result.timingMessage += genTimeInfo(PREPARE_TAG,start);
        return result;
    }


    @WebMethod
    public ServiceResult updateUser(
            /*@WebParam(name="Id") @XmlElement(required=true, nillable=true, name="Id")   Long Id, */
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="region") Long region,
            @WebParam(name="password") String password,
            @WebParam(name="fileName")@XmlElement(required=false, nillable=true, name="fileName")      String fileName,
            @WebParam(name="fileImage")@XmlElement(required=false, nillable=true, name="fileImage")      String fileImage
    ) {
        String fullPath = "";
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        User user = null;
        long start = System.currentTimeMillis() % 1000;

        if (password.isEmpty()) {
            result.IsSuccess = false;
            result.errorMessage = INVALID_USERNAME_OR_PASS;
            result.timingMessage += genTimeInfo(PREPARE_TAG,start);
            return result;
        }

        CustomObjResult res = isTokenCorrectWithUser(sessionToken);

        if (!sessionToken.isEmpty() && res.isBoolVal == false) {
            result.IsSuccess = false;
            result.errorMessage = INVALID_TOKEN;
            result.timingMessage += genTimeInfo(PREPARE_TAG,start);
            return result;
        }

        User findedUser  = getUserByToken(sessionToken);

        //По имени не найден пользователь, который обновляется
        if (!sessionToken.isEmpty() && findedUser == null) {
            result.IsSuccess = false;
            result.errorMessage = INVALID_USERNAME_OR_PASS_OR_PHONE;
            result.timingMessage += genTimeInfo(PREPARE_TAG,start);
            return result;
        }


        //
        if (user == null && findedUser!=null && res.isBoolVal == true) {
            user = findedUser;
        }
        else {
            if(user==null) {
                result.IsSuccess = false;
                result.errorMessage = INVALID_TOKEN_OR_USER_ID;
                result.timingMessage += genTimeInfo(PREPARE_TAG,start);
                return result;

            }
        }
        if (user  != null) {
            user.setCreationDate(new Timestamp(System.currentTimeMillis()));
            user.setModifyDate(new Timestamp(System.currentTimeMillis()));
            //user.setPassword(password);
            user.setStatus(Userstatus.StatusCommon); //Const : common user

            fullPath = F_WEB_FILES_USER_AVATAR_PHOTO + String.valueOf(user.hashCode()) + System.currentTimeMillis() + fileName;
            try {
                if (WSUtility.saveByteToFile(fileImage.getBytes("UTF-8"), fullPath) == true) {
                    user.setUserPhotoPath(fullPath);
                }
                else {
                    user.setUserPhotoPath("");
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            user.setRegion(region);

            result = saveUserAndRetJson(user);
            result.timingMessage += genTimeInfo(PREPARE_TAG,start);
            return result;
        }
        result.IsSuccess = false;
        result.errorMessage =  INVALIDE_DATA;
        result.timingMessage += genTimeInfo(PREPARE_TAG,start);
        return result;
    }


    @WebMethod
    public ServiceResult updateUserPassword(
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="password") String password
    ) {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        User user = null;
        long start = System.currentTimeMillis() % 1000;

        if (password.isEmpty()) {
            result.IsSuccess = false;
            result.errorMessage = INVALID_USERNAME_OR_PASS;
            result.timingMessage += genTimeInfo(PREPARE_TAG,start);
            return result;
        }

        CustomObjResult res = isTokenCorrectWithUser(sessionToken);

        if (!sessionToken.isEmpty() && res.isBoolVal == false) {
            result.IsSuccess = false;
            result.errorMessage = INVALID_TOKEN;
            result.timingMessage += genTimeInfo(PREPARE_TAG,start);
            return result;
        }


        User findedUser  = getUserByToken(sessionToken);

        //По имени не найден пользователь, который обновляется
        if (!sessionToken.isEmpty() && findedUser == null) {
            result.IsSuccess = false;
            result.errorMessage = INVALID_USERNAME_OR_PASS_OR_PHONE;
            result.timingMessage += genTimeInfo(PREPARE_TAG,start);
            return result;
        }



        if (user == null && findedUser!=null && res.isBoolVal == true) {
            user = findedUser;
        }
        else {
            if(user==null) {
                result.IsSuccess = false;
                result.errorMessage = INVALID_TOKEN_OR_USER_ID;
                result.timingMessage += genTimeInfo(PREPARE_TAG,start);
                return result;

            }
        }

        if (user  != null) {
            user.setModifyDate(new Timestamp(System.currentTimeMillis()));
            user.setPassword(password);
            result = saveUserAndRetJson(user);
            result.timingMessage += genTimeInfo(PREPARE_TAG,start);
            return result;
        }
        result.IsSuccess = false;
        result.errorMessage =  INVALIDE_DATA;
        result.timingMessage += genTimeInfo(PREPARE_TAG,start);
        return result;
    }



    @WebMethod
    public ServiceResult insertRequest(
            /*@WebParam(name="Id") @XmlElement(required=false, nillable=true, name="Id")               Long Id,*/
            @WebParam(name="sessionToken")      String sessionToken,
            @WebParam(name="description")       String description,
            @WebParam(name="latitude")@XmlElement(required=false, nillable=true, name="latitude")          Double latitude,
            @WebParam(name="longitude")@XmlElement(required=false, nillable=true, name="longitude")         Double longitude,
            @WebParam(name="isResolvedByUserId") @XmlElement(required=false, nillable=true, name="isResolvedByUserId")   Long isResolvedByUserId,
            @WebParam(name="typeId") @XmlElement(required=false, nillable=true, name="typeId")           Long typeId,
            @WebParam(name="regionId")@XmlElement(required=false, nillable=true, name="regionId")          Long regionId,
            @WebParam(name="fileName")@XmlElement(required=false, nillable=true, name="fileName")          String fileName,
            @WebParam(name="fileImage")@XmlElement(required=false, nillable=true, name="fileImage")        String fileImage

    ) {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

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
                result.IsSuccess = false;
                result.errorMessage = INVALIDE_ACTIVE_REQ;
                result.timingMessage += genTimeInfo(PREPARE_TAG,start);
                return result;
            }

            if (createUserByToken > 0) {
            request = new Request();
            request.setIsDeleted(isDeletedFalse);
            request.setCreationDate(new Timestamp(System.currentTimeMillis()));
            request.setModifyDate(new Timestamp(System.currentTimeMillis()));
            request.setCreationUser(createUserByToken);
            request.setStatus(Requeststatus.StatusOpen);

                if (request!=null) {

                    if (isResolvedByUserId != null) {
                        User findedUser = usersManagers.findOne(isResolvedByUserId);

                        if (findedUser!=null) {
                            request.setResolvedByUser(isResolvedByUserId);
                            //Id юзера создавшего запрос - совпадает с юзером который запрос разрешил
                            if (isResolvedByUserId == createUserByToken) {
                                request.setIsResolvedByUser((byte)1);
                                request.setStatus(Requeststatus.StatusClose);
                                request.setCloseDate(new Timestamp(System.currentTimeMillis()));
                                request.setModifyDate(new Timestamp(System.currentTimeMillis()));
                            }
                        }
                        result = saveRequestAndRetJson(request);
                        result.timingMessage += genTimeInfo(PREPARE_TAG,start);
                        return result;
                    }

                    if (description.isEmpty() == false) {
                        request.setDescription(description);
                    }

                    if (latitude !=null && longitude != null) {
                        request.setLatitude(latitude);
                        request.setLongitude(longitude);
                    }

                    request.setModifyDate(new Timestamp(System.currentTimeMillis()));

                    if (    typeId == Requesttype.TypeAccumIsDown ||
                            typeId == Requesttype.TypeNotStarted ||
                            typeId == Requesttype.TypeStuck ||
                            typeId == Requesttype.TypeAlarm ||
                            typeId == Requesttype.TypeCarNotOpen ||
                            typeId == Requesttype.TypeTowTruckNeed
                            ) {
                        request.setType(typeId);
                    }
                    if (regionId != null) {
                        request.setRegion(regionId);
                    }
                    if (!fileName.isEmpty()) {
                        fileDirName = F_WEB_FILES_REQUEST_PHOTO + String.valueOf(request.hashCode()) + System.currentTimeMillis() + fileName;
                        try {
                            if (saveByteToFile(fileImage.getBytes("UTF-8"), fileDirName) == true) {
                                request.setRequestPhotoPath(fileDirName);
                            }
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }

                    result = saveRequestAndRetJson(request);
                    result.timingMessage += genTimeInfo(OVERALL_TAG,start);
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

        result.timingMessage += genTimeInfo(PREPARE_TAG,start);
        return result;
    }


    @WebMethod
    public ServiceResult updateRequest(
            @WebParam(name="Id") @XmlElement(required=true, nillable=true, name="Id")               Long Id,
            @WebParam(name="sessionToken")      String sessionToken,
            @WebParam(name="description")       String description,
            @WebParam(name="latitude")          Double latitude,
            @WebParam(name="longitude")         Double longitude,
            @WebParam(name="statusId")          Long statusId,
            @WebParam(name="isResolvedByUser")  Long isResolvedByUserId,
            @WebParam(name="typeId")            Long typeId,
            @WebParam(name="regionId")          Long regionId,
            @WebParam(name="fileName")@XmlElement(required=false, nillable=true, name="fileName")          String fileName,
            @WebParam(name="fileImage")@XmlElement(required=false, nillable=true, name="fileImage")        String fileImage

    ) {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;
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

                if (Id != null) {
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
                    request.setIsDeleted(isDeletedFalse);
                    request.setCreationDate(new Timestamp(System.currentTimeMillis()));
                    request.setCreationUser(createUserByToken);
                }

                if (request!=null) {

                    if (isResolvedByUserId != null) {
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
                        result.timingMessage += genTimeInfo(PREPARE_TAG,start);
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
                        try {
                            if (saveByteToFile(fileImage.getBytes("UTF-8"), fileDirName) == true) {
                                request.setRequestPhotoPath(fileDirName);
                            }
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                    }

                    result = saveRequestAndRetJson(request);
                    result.timingMessage += genTimeInfo(OVERALL_TAG,start);
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

        result.timingMessage += genTimeInfo(PREPARE_TAG,start);
        return result;
    }

    @WebMethod
    public ServiceResult closeCurrentActiveRequestByCustomUser(
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="UserId")        Long UserId
    ) {
        String fullPath = "";
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        User user = null;
        long start = System.currentTimeMillis() % 1000;

        CustomObjResult res = isTokenCorrectWithUser(sessionToken);

        if (!sessionToken.isEmpty() && res.isBoolVal == false) {
            result.IsSuccess = false;
            result.errorMessage = INVALID_TOKEN;
            result.timingMessage += genTimeInfo(PREPARE_TAG,start);
            return result;
        }

        List<Request> allActiveUserRequest  = requestService.
                findRequestByCreationUserAndStatus(
                        res.userId,
                        Requeststatus.StatusOpen );

        ArrayList<String> errList = new ArrayList<String>();

        if (allActiveUserRequest.size() > 1) {
            result.IsSuccess = false;
            result.errorMessage = INVALIDE_ACTIVE_REQ;
            result.timingMessage += genTimeInfo(PREPARE_TAG,start);
            return result;
        }

        for (Request item: allActiveUserRequest
                ) {
            item.setStatus(Requeststatus.StatusClose);
            item.setCloseDate(new Timestamp(System.currentTimeMillis()));
            item.setModifyDate(new Timestamp(System.currentTimeMillis()));
            item.setIsResolvedByUser((byte) 1);
            item.setResolvedByUser( UserId);
            result =  saveRequestAndRetJson(item);
            if (res.isBoolVal == false) {
                errList.add(item.getId().toString());
            }
        }
        result.IsSuccess = true;
        result.errorMessage = "";
        if (!errList.isEmpty()) {
            result.IsSuccess = false;
            result.errorMessage = "Error with request Ids : " + errList.toString();
        }
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }


    @WebMethod
    public ServiceResult closeAllActiveRequestByAuthor(
            @WebParam(name="sessionToken")  String sessionToken
    ) {
        String fullPath = "";
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        User user = null;
        long start = System.currentTimeMillis() % 1000;

        CustomObjResult res = isTokenCorrectWithUser(sessionToken);

        if (!sessionToken.isEmpty() && res.isBoolVal == false) {
            result.IsSuccess = false;
            result.errorMessage = INVALID_TOKEN;
            result.timingMessage += genTimeInfo(PREPARE_TAG,start);
            return result;
        }

        List<Request> allActiveUserRequest  = requestService.
                                            findRequestByCreationUserAndStatus(
                                                                                res.userId,
                                                                                Requeststatus.StatusOpen );

        ArrayList<String> errList = new ArrayList<String>();

        for (Request item: allActiveUserRequest
             ) {
            item.setStatus(Requeststatus.StatusClose);
            item.setCloseDate(new Timestamp(System.currentTimeMillis()));
            item.setModifyDate(new Timestamp(System.currentTimeMillis()));
            item.setIsResolvedByUser((byte) 1);
            result =  saveRequestAndRetJson(item);
            if (res.isBoolVal == false) {
                errList.add(item.getId().toString());
            }
        }
        result.IsSuccess = true;
        result.errorMessage = "";
        if (!errList.isEmpty()) {
            result.IsSuccess = false;
            result.errorMessage = "Error with request Ids : " + errList.toString();
        }

        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }
    /*
    @WebMethod
    public ServiceResult updateUserAuto(
            @WebParam(name="sessionToken") String sessionToken,
            @WebParam(name="name")   String name,
            @WebParam(name="haveCable")   Byte haveCable,
            @WebParam(name="transmissionType") Long transmissionType
    ) {
        String fullPath = "";
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        Auto auto = null;

        CustomObjResult res = isTokenCorrectWithUser(sessionToken);

        if (res.isBoolVal == false || res.userId  == null) {
            result.IsSuccess = false;
            result.errorMessage = INVALID_TOKEN;
            return result;
        }
        auto = autoManagers.findFirstByUser(res.userId);

        if (auto!= null && !name.isEmpty() && transmissionType!=null)  {
            auto.setName(name);
            auto.setTransmissionType(transmissionType);
            auto.setHaveCable(haveCable);

            result = saveAutoAndRetJson(auto);
            return result;
        }
        result.IsSuccess = false;
        result.errorMessage =  INVALIDE_DATA;
        return result;
    }
    */

    @WebMethod
    public ServiceResult getSessionToken(
            @WebParam(name="name") String name,
            @WebParam(name="password") String password)
    {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        User user = null;
        Session findSession = null;

        user = userService.findFirstByNameAndPassword(name, password);
        if (user !=null)
        {
            findSession = sessionService.findSessionByUserId(user.getId());
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());

            if (findSession == null) {
                findSession = new ru.Entity.Session();
                findSession.setUser(user.getId());
                findSession.setCreationDate(currentTime);
                findSession.setToken(WSUtility.generateHash(user.getName()+user.getPassword()+ currentTime.toString()));
                sessionManagers.save(findSession);
            }

            result = objToJson(findSession,genTimeInfo(PREPARE_TAG,start));
            return  result;
        }
        result.timingMessage += genTimeInfo(PREPARE_TAG,start);
        return result;
    }


    @WebMethod()
    public ServiceResult insertMessage(
            /* @WebParam(name="Id")            Long Id, */
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="text")          String text,
            @WebParam(name="requestId") @XmlElement(required=false, nillable=true, name="requestId")    Long requestId,
            @WebParam(name="regionId") @XmlElement(required=false, nillable=true, name="regionId")      Long regionId,
            @WebParam(name="userRx") @XmlElement(required=false, nillable=true, name="userRx")          Long userRx,
            @WebParam(name="typeId") @XmlElement(required=false, nillable=true, name="typeId")          Long typeId,
            @WebParam(name="fileId") @XmlElement(required=false, nillable=true, name="fileId")          Long fileId,
            @WebParam(name="fileName") @XmlElement(required=false, nillable=true, name="fileName")      String fileName,
            @WebParam(name="fileImage") @XmlElement(required=false, nillable=true, name="fileImage")     String fileImage

    ) {
        Message msg;
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        String fileDirName = "";
        CustomObjResult res = isTokenCorrectWithUser(sessionToken);
        Long createUserByToken = res.userId;
        if (res.isBoolVal == true)
        {
            if (createUserByToken > 0) {

                msg = new Message();
                msg.setCreationDate(new Timestamp(System.currentTimeMillis()));
                msg.setIsDeleted(isDeletedFalse);

                if (msg!=null) {
                    msg.setModifyDate(new Timestamp(System.currentTimeMillis()));

                    if (regionId != null && regionId > 0){
                        msg.setRegion(regionId);
                    }
                    if (requestId != null && requestId > 0){
                        msg.setRequest(requestId);
                    }
                    if (typeId !=null && typeId > 0){
                        msg.setType(typeId);
                    }
                    if (userRx !=null && userRx > 0){
                        msg.setUserRx(userRx);
                    }

                    if (fileId !=null && fileId > 0){
                        msg.setFiles(fileId);
                    }

                    User user = getUserByToken(sessionToken);


                    msg.setText(text);
                    msg.setCreateUser(createUserByToken);
                    if (user!=null) {
                        msg.setCreateUserName(user.getName());
                    }
                    fileDirName = F_WEB_FILES_MESSAGE_PHOTO + String.valueOf(msg.hashCode()) + System.currentTimeMillis() + fileName;
                    try {
                        if (saveByteToFile(fileImage.getBytes("UTF-8"), fileDirName) == true) {
                            msg.setMessagePhotoPath(fileDirName);
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
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

        result.timingMessage += genTimeInfo(OVERALL_TAG,start);

        if (result.IsSuccess && sendPushNotification!=null) {
            sendPushNotification.execute("region_" + regionId.toString(),"insertMessage", result.ResultObjectJSON, "New message in region chat");
        }
        return result;
    }

    @WebMethod
    public ServiceResult getMessageByRegionAndIdGreater(
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="regionId")      Long regionId,
            @WebParam(name="lastId")        Long Id,
            @WebParam(name="pageSize")      int pageSize

            ) {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        if (isTokenCorrect(sessionToken))
        {
            result = objToJson(messageService.findMessageByRegionAndAndIdAfter(regionId, Id,pageSize ),
                    "");
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }



    @WebMethod()
    public ServiceResult insertFile(
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="fileName")      String fileName,
            @WebParam(name="description")   String description,
            @WebParam(name="fileType")      String fileType,
            @WebParam(name="createUser") @XmlElement(required=false, nillable=true, name="createUser")   Long createUser,
            @WebParam(name="fileImage") @XmlElement(required=false, nillable=true, name="fileImage")     String fileImage
    ) {
        Files file;
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        String fileDirName = "";
        CustomObjResult res = isTokenCorrectWithUser(sessionToken);
        Long createUserByToken = res.userId;
        if (res.isBoolVal == true)
        {
            if (createUserByToken > 0) {

                file = new Files();

                if (file!=null) {
                    file.setCreationDate(new Timestamp(System.currentTimeMillis()));
                    file.setIsDeleted(isDeletedFalse);

                    file.setModifyDate(new Timestamp(System.currentTimeMillis()));

                    if (description != null){
                        file.setDescription(description);
                    }
                    if (fileName != null){
                        file.setFileName(fileName);
                    }
                    if (fileType != null){
                        file.setFileType(fileType);
                    }

                    if (createUser !=null){
                        file.setCreationUser(createUser);
                    }

                    User user = getUserByToken(sessionToken);

                    file.setCreationUser(createUserByToken);
                    if (user!=null) {
                        file.setCreationUser(user.getId());
                    }
                    fileDirName = F_WEB_FILES_MESSAGE_PHOTO + String.valueOf(file.hashCode()) + System.currentTimeMillis() + fileName;
                    try {
                        if (saveByteToFile(fileImage.getBytes("UTF-8"), fileDirName) == true) {
                            file.setFullPhotoPath(fileDirName);
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }

                    result = saveFileAndRetJson(file);
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

        result.timingMessage += genTimeInfo(OVERALL_TAG,start);

        if (result.IsSuccess && sendPushNotification!=null) {
        }
        return result;
    }


    @WebMethod
    public ServiceResult getFileById(
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="id")            Long id
    ) {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        if (isTokenCorrect(sessionToken))
        {
            result = objToJson(filesService.findFirstById(id ),
                    "");
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }


    @WebMethod
    public ServiceResult findMessageByRegionAndCreationDateBetweenOrderByIdAsc(
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="regionId")      Long regionId,
            @WebParam(name="startDate")     Date startDate,
            @WebParam(name="endDate")       Date endDate,
            @WebParam(name="page")          int page,
            @WebParam(name="pageSize")      int pageSize

    ) {
        boolean isErrorInParams = false;
        if (regionId == null || startDate == null || endDate == null || page < 0 || pageSize < 1) {
            isErrorInParams = true;
        }
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        if (isTokenCorrect(sessionToken) && !isErrorInParams)
        {
            result = objToJson(messageService.findMessageByReqionAndCreationDateBetweenOrderByIdAsc(
                    regionId,
                    startDate,
                    endDate,
                    page,
                    pageSize ),
                    "");
        }
        else if(!isErrorInParams) {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        else {
            result.errorMessage = INVALIDE_DATA;
            result.IsSuccess = false;
        }
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }


    @WebMethod
    public ServiceResult findMessageByRegionAndCreationDateBetweenOffset(
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="regionId")      Long regionId,
            @WebParam(name="offset")        int offset,
            @WebParam(name="page")          int page,
            @WebParam(name="pageSize")      int pageSize

    ) {
        boolean isErrorInParams = false;
        if (regionId == null || page < 0 || pageSize < 1) {
            isErrorInParams = true;
        }
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        if (isTokenCorrect(sessionToken) && !isErrorInParams)
        {
            Date now = new Date();

            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY,23 );
            cal.set(Calendar.MINUTE,59);
            cal.set(Calendar.SECOND,59);
            cal.set(Calendar.MILLISECOND,59);
            Date endDate = cal.getTime();

            Calendar prev = Calendar.getInstance();
            prev.set(Calendar.HOUR_OF_DAY,0 );
            prev.set(Calendar.MINUTE,0);
            prev.set(Calendar.SECOND,0);
            prev.set(Calendar.MILLISECOND,0);

            Date startDate  = new DateTime(prev).minusDays(offset).toDate();
            result = objToJson(messageService.findMessageByReqionAndCreationDateBetweenOrderByIdAsc(
                    regionId,
                    startDate,
                    endDate,
                    page,
                    pageSize ),
                    "");
        }
        else if(!isErrorInParams) {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        else {
            result.errorMessage = INVALIDE_DATA;
            result.IsSuccess = false;
        }
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }





    @WebMethod
    public ServiceResult getAllMessageByRequest(
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="request")       Long request,
            @WebParam(name="startRow")      int startRow,
            @WebParam(name="pageSize")      int pageSize

    ) {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        if (isTokenCorrect(sessionToken))
        {
            result=  objToJson(messageService.findAllMessageByRequest(request, startRow, pageSize ),"");

        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }

    @WebMethod
    public ServiceResult getAllRequestByCreationUser(
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="userId")        Long userId
    ) {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        if (isTokenCorrect(sessionToken))
        {
            result =   objToJson(requestService.findRequestByCreationUser(userId ),
                    "");
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }


    @WebMethod
    public ServiceResult getActiveRequestByCreationUser(
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="userId")        Long userId
    ) {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        if (isTokenCorrect(sessionToken))
        {
            result = objToJson(requestService.findRequestByCreationUserAndStatus(userId,Requeststatus.StatusOpen ),
                    "");
            result.IsSuccess = true;
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }

    @WebMethod
    public ServiceResult getAllOpenRequestByRegion(
            @WebParam(name="sessionToken")  String sessionToken,
            @WebParam(name="regionId")        Long regionId,
            @WebParam(name="typeIds") @XmlElement(required=false, nillable=true, name="typeIds")       String typeIds

    ) {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        List<Long> listTypeIds = null;
        if (isTokenCorrect(sessionToken))
        {
            if (typeIds.length() <= 0) {
                result = objToJson(requestService.findRequestByRegionAndStatus(regionId, Requeststatus.StatusOpen ),
                        "");
            }
            else {
                if (typeIds.length() > 0) {
                    listTypeIds = Arrays.stream(typeIds.split(",")).map(Long::parseLong).collect(Collectors.toList());
                }
                result = objToJson(requestService.findRequestByRegionAndStatusAndTypeIn(regionId, Requeststatus.StatusOpen,listTypeIds ),
                        "");
                result.IsSuccess = true;
            }
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }

    @WebMethod
    public ServiceResult findRequestResolvedByCurrentUserWithTypeFilter(
            @WebParam(name="sessionToken")   String sessionToken,
            @WebParam(name="typeIds") @XmlElement(required=false, nillable=true, name="typeIds")       String typeIds
    ) {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        List<Long> listTypeIds = null;
        long start = System.currentTimeMillis() % 1000;

        CustomObjResult res = isTokenCorrectWithUser(sessionToken);

        if (res.isBoolVal && res.userId > 0)
        {
            if (typeIds.isEmpty()) {
                result = objToJson(requestService.findRequestByResolvedByUserAndStatus(
                        res.userId, Requeststatus.StatusClose ),"");
                result.IsSuccess = true;
            }
            else {

                    if (typeIds.length() > 0) {
                        listTypeIds = Arrays.stream(typeIds.split(",")).map(Long::parseLong).collect(Collectors.toList());
                    }

                    if (!listTypeIds.isEmpty())
                    {
                        result = objToJson(requestService.findRequestByResolvedByUserAndStatusAndTypeIn(
                                res.userId, Requeststatus.StatusClose,listTypeIds ),"");
                    }
                }
            }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }

    @WebMethod
    public ServiceResult getUserInfo(
            @WebParam(name="sessionToken") String sessionToken) {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        if (isTokenCorrect(sessionToken))
        {
            Session session = null;
            if (sessionService != null) {
                session = sessionService.findSessionByToken(sessionToken);
            }
            result = objToJson(session.getUserByUser(),"");
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }

    @WebMethod
    public ServiceResult getAllMessageTypes(
            @WebParam(name="sessionToken") String sessionToken) {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        if (isTokenCorrect(sessionToken))
        {
            result = objToJson(messageTypeService.findAll(),"");
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }

    @WebMethod
    public ServiceResult getAllRequestType(
            @WebParam(name="sessionToken") String sessionToken) {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        if (isTokenCorrect(sessionToken))
        {
            result = objToJson(requestTypeService.findAll(),"");
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }

    @WebMethod
    public ServiceResult getAllTransmissionType(
            @WebParam(name="sessionToken") String sessionToken)
    {

        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        if (isTokenCorrect(sessionToken))
        {
            result  = objToJson(trTypeService.findAll(),"");
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }

    @WebMethod
    public ServiceResult getAllToolType(
            @WebParam(name="sessionToken") String sessionToken)
    {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        if (isTokenCorrect(sessionToken))
        {
            result = objToJson(toolTypeService.findAll(),"");
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }

    @WebMethod
    public ServiceResult getAllAchievmenttype(
            @WebParam(name="sessionToken") String sessionToken) {

        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        if (isTokenCorrect(sessionToken))
        {
            result = objToJson(achievTypeService.findAll(),"");
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }


    @WebMethod
    public ServiceResult getAllAchievmentByUser(
            @WebParam(name="sessionToken") String sessionToken,
            @WebParam(name="user") Long userId)
    {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        User user = null;
        List<Achievement> achievs = null;
        if (isTokenCorrect(sessionToken))
        {
            user = usersManagers.findOne(userId);
            if (user!=null && user.getId()!=null) {
                result = objToJson(achievService.findAchievementByUser(user.getId()),"");
            }
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }

        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }


    @WebMethod
    public ServiceResult getAllToolByUser(
            @WebParam(name="sessionToken") String sessionToken,
            @WebParam(name="user") Long userId)
    {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        User user = null;
        List<Tool> achievs = null;
        if (isTokenCorrect(sessionToken))
        {
            user = usersManagers.findOne(userId);
            if (user!=null && user.getId()!=null) {
                result = objToJson(toolService.findToolsByUser(user.getId()),"");
            }
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }


    @WebMethod
    public ServiceResult insertUpdateUserAuto(
            @WebParam(name="sessionToken") String sessionToken,
            @WebParam(name="name")   String name,
            @WebParam(name="haveCable")   Byte haveCable,
            @WebParam(name="transmissionType") Long transmissionType

    ) {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        Auto auto = null;
        long start = System.currentTimeMillis() % 1000;

        CustomObjResult res = isTokenCorrectWithUser(sessionToken);

        if (setResult(result, start, res)) return result;

        if (name.isEmpty()) {
            result.IsSuccess = false;
            result.errorMessage = INVALID_USERNAME_OR_PASS;
            result.timingMessage += genTimeInfo(PREPARE_TAG,start);
            return result;
        }

        auto  = autoService.findFirstAutoByUser(res.userId);

        //Проверка имени на повтор
        if (!name.isEmpty() && res!=null && res.userId!=null) {
            if (auto == null) {
                auto = new Auto();
                auto.setIsDeleted(isDeletedFalse);
                auto.setUser(res.userId);
            }
        }

        if (auto  != null && res!=null && res.userId!=null) {
            auto.setName(name);
            auto.setHaveCable(haveCable);
            auto.setTransmissionType(transmissionType);

            result = saveAutoAndRetJson(auto);
            result.timingMessage += genTimeInfo(OVERALL_TAG,start);
            return result;
        }
        else {
            result.IsSuccess = false;
            result.errorMessage =  INVALIDE_DATA;
        }
        result.timingMessage += genTimeInfo(PREPARE_TAG,start);
        return result;
    }

    private boolean setResult(ServiceResult result, long start, CustomObjResult res) {
        if (res.isBoolVal == false)
        {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
            result.timingMessage += genTimeInfo(PREPARE_TAG,start);
            return true;
        }
        return false;
    }


    @WebMethod
    public ServiceResult getAllAutoByUser(
            @WebParam(name="sessionToken") String sessionToken,
            @WebParam(name="user") Long userId)
    {

        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        User user = null;
        List<Tool> tools = null;
        if (isTokenCorrect(sessionToken))
        {
            user = usersManagers.findOne(userId);
            if (user!=null && user.getId()!=null) {
                result = objToJson(autoService.findFirstAutoByUser(user.getId()), "");
            }
        }
        else {
            result.errorMessage = INVALID_TOKEN;
            result.IsSuccess = false;
        }
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }


    @WebMethod
    public ServiceResult getAllRegions(
            @WebParam(name="sessionToken") String sessionToken)
    {
        ServiceResult result = new ServiceResult();
        result.IsSuccess= false;
        long start = System.currentTimeMillis() % 1000;

        //if (isTokenCorrect(sessionToken))
        //{
        result = objToJson(regionService.findAll(),"");
        result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        return result;
    }

    @WebMethod
    public ServiceResult insertUpdateUserTools(
            @WebParam(name="sessionToken") String sessionToken,
            @WebParam(name="toolTypeIds")@XmlElement(required=false, nillable=true, name="toolTypeIds")
                                         String ToolTypeIds
    ) {
        ServiceResult result = new ServiceResult();
        long start = System.currentTimeMillis() % 1000;
        result.IsSuccess= false;
        List<Tool> tools = null;
        Tool tool = null;
        ArrayList<Long> setToolTypeIds = new ArrayList<Long>();

        String[] stringArray = ToolTypeIds.split(",");

        for (int i = 0; i < stringArray.length; i++) {
            setToolTypeIds.add( Long.parseLong(stringArray[i]));
        }

        ArrayList<Long> toolsToAdd = new ArrayList<Long>();
        ArrayList<Long> toolsToRemove = new ArrayList<Long>();


        CustomObjResult res = isTokenCorrectWithUser(sessionToken);

        if (setResult(result, start, res)) return result;
        List<Tooltypes> allToolTypes = toolTypeService.findAll();
        List<Long> allToolTypesIds = allToolTypes.stream()
                .map(Tooltypes::getId)
                .collect(Collectors.toList());

        tools  = toolService.findToolsByUser(res.userId);
        List<Long> currentUserToolTypesIds = tools.stream()
                .map(Tool::getType)
                .collect(Collectors.toList());



        //в случае если было пусто и устанавливают пусто
        if (tools.isEmpty() && setToolTypeIds.isEmpty())
        {
            result.IsSuccess = true;
            result.timingMessage += genTimeInfo(PREPARE_TAG,start);
            return result;
        }

        for (Long item: setToolTypeIds
             ) {
            if (!allToolTypesIds.contains(item)) {
                result.IsSuccess = false;
                result.errorMessage = "Error: Item with Id " + item + " not correct, break all";
                result.timingMessage += genTimeInfo(PREPARE_TAG,start);
                return result;
            }
        }
        //Определение что нужно добавить из типов инструментов и что удалить
        toolsToAdd = new ArrayList<Long>(setToolTypeIds);
        toolsToAdd.removeAll(currentUserToolTypesIds);

        toolsToRemove = new ArrayList<Long>(currentUserToolTypesIds);
        toolsToRemove.removeAll(setToolTypeIds);

        for (Long itemId: toolsToRemove
                ) {
            tool = tools.stream().filter(p -> p.getType() == itemId).findAny()// If 'findAny' then return found
                    .orElse(null);

            if (tool!=null) {
                tool.setIsDeleted(isDeletedTrue);
                saveToolAndRetJson(tool);
            }
        }

        for (Long itemId: toolsToAdd
                ) {
            tool = new Tool();
            tool.setIsDeleted(isDeletedFalse);
            tool.setType(itemId);
            tool.setUser(res.userId);
            saveToolAndRetJson(tool);
        }

        try {
            result.ResultObjectJSON = objToJson(toolService.findToolsByUser(res.userId),"").ResultObjectJSON;
            result.IsSuccess = true;
            result.errorMessage =  "Removed : " + toolsToRemove.toString() + " " +
                    "Added : " + toolsToAdd.toString() + " "  ;
            result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        }
        catch (Exception ex)
        {
            result.errorMessage = INVALIDE_DATA;
            result.IsSuccess = false;
            result.timingMessage += genTimeInfo(OVERALL_TAG,start);
        }
        return result;
    }

    public static String genTimeInfo(String tagName, long startTimeMs)
    {
        return  "<" + tagName+">" + ((System.currentTimeMillis() % 1000)-startTimeMs) + "</" + tagName+">";
    }

    public WebServiceMain(GenericXmlApplicationContext context)
    {
        ctx = context;
    }


    private void initContext()
    {
        if (ctx == null) {
            Logger root = Logger.getRootLogger();
            root.setLevel(Level.ERROR);
            root.addAppender(new ConsoleAppender(
                    new PatternLayout(PatternLayout.TTCC_CONVERSION_PATTERN)));
            BasicConfigurator.configure();
            ctx = new GenericXmlApplicationContext();
            ctx.load("classpath:spring-config.xml");
            ctx.refresh();
            sendPushNotification = new SendPushNotification();

        }
    }

    private void initService()
    {
        if (ctx!=null) {
            if (
                    regionManagers  == null ||
                    sessionManagers == null ||
                    usersManagers   == null ||
                    requestManagers == null ||
                    messageManagers == null ||
                    autoManagers    == null ||
                    toolsManagers   == null ||
                    filesManagers   == null
                    ) {
                regionManagers = ctx.getBean(RegionManagers.class);
                sessionManagers = ctx.getBean(SessionManagers.class);
                usersManagers = ctx.getBean(UsersManagers.class);
                requestManagers = ctx.getBean(RequestManagers.class);
                messageManagers = ctx.getBean(MessageManagers.class);
                autoManagers = ctx.getBean(AutoManagers.class);
                toolsManagers = ctx.getBean(ToolManagers.class);
                filesManagers = ctx.getBean(FilesManagers.class);
            }


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
            if (filesService == null) filesService = new FilesService(ctx);
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
