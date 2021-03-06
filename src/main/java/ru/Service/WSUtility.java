package ru.Service;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class WSUtility {
    //f:\WebFiles
    public static final String F_WEB_FILES_COMMON = "/opt/tomcat/webapps/upload";
    public static final String F_WEB_FILES_REQUEST_PHOTO = F_WEB_FILES_COMMON + "/request_photo/";
    public static final String F_WEB_FILES_USER_AVATAR_PHOTO = F_WEB_FILES_COMMON + "/user_ava_photo/";
    public static final String F_WEB_FILES_MESSAGE_PHOTO = F_WEB_FILES_COMMON + "/message_photo/";

    public static final String INVALID_USERNAME_OR_PASS = "INVALID_USERNAME_OR_PASS";
    public static final String INVALID_USERNAME_OR_PASS_OR_PHONE = "INVALID_USERNAME_OR_PASS_OR_PHONE";
    public static final String INVALID_USERNAME_ALLREADY_EXIST = "USERNAME_ALLREADY_EXIST";
    public static final String INVALID_EMAIL_ALLREADY_EXIST = "EMAIL_ALLREADY_EXIST";
    public static final String INVALID_USERNAME_OR_EMAIL= "INVALID_USERNAME_OR_EMAIL";

    public static final String INVALID_TOKEN = "INVALID TOKEN";
    public static final String INVALID_TOKEN_OR_USER_ID = "INVALID_TOKEN_OR_USER_ID";
    public static final String INVALIDE_DATA = "INVALID DATA";
    public static final String INVALIDE_ACTIVE_REQ = "INVALIDE_ACTIVE_REQ";

    public static ObjectMapper mapper = new ObjectMapper();

    public static ServiceResult objToJson(Object obj, String timingMsg) {
        ServiceResult res = new ServiceResult();
        long start = System.currentTimeMillis() % 1000;
        res.IsSuccess = false;

        try {
            res.ResultObjectJSON = mapper.writeValueAsString(obj);
            res.IsSuccess = true;
            res.errorMessage = "";
        } catch (Exception e) {
            res.errorMessage = INVALIDE_DATA;
            res.IsSuccess = false;
            res.ResultObjectJSON = "";
            e.printStackTrace();
        }
        res.timingMessage = timingMsg + WebServiceMain.genTimeInfo("objToJson",start );
        return res;
    }

    public static String generateHash(String s) {
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


    public static boolean saveByteToFile(byte[] fileImage, String fullPathToSave)
    {
        byte[] encodedBytes;
        boolean isSuccess = false;
        if (fileImage!=null && fileImage.length > 0) {

            encodedBytes = Base64.getDecoder().decode(fileImage);

            try (FileOutputStream fos = new FileOutputStream(  fullPathToSave )) {

                fos.write(encodedBytes);
                isSuccess = true;
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
            File file = new File(fullPathToSave);
            if (file!=null) {
                file.setExecutable(false);
                file.setReadable(true);
                file.setWritable(true);
            }

        }
        return isSuccess;
    }
}
