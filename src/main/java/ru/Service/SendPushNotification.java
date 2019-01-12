package ru.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import com.sun.net.httpserver.Authenticator;

import static ru.Service.WSUtility.objToJson;


public class SendPushNotification  {

    /**
     *
     */
    private static final long serialVersionUID = -8022560668279505764L;

    // Method to send Notifications from server to client end.
    public final static String AUTH_KEY_FCM = "AAAA8oyQQ1A:APA91bGFnAQgebxAz5TiVjc9mvs1_ASTm8Vvu1dPeB1tZpbO9gyUEupwOe4mft-oe97Pav-Kjf5D5Z9JrLmFWK7zWDHjmwqmav_-0gYGEwPopqE2rU6LCt3TQ1DwvyHjHGPfpPftrgKg";
    public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";
    public final static String DEVICE_ID = "1041740350288   ";

    public String execute(String topic, String title, String data, String body) {
        String DeviceIdKey = DEVICE_ID;
        String authKey = AUTH_KEY_FCM;
        String FMCurl = API_URL_FCM;

        try {
            URL url = new URL(FMCurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "key=" + authKey);
            conn.setRequestProperty("Content-Type", "application/json");

            FcmNotifyRequest dataReq = new FcmNotifyRequest();

            dataReq.data = new data();
            dataReq.data.message = data;
            dataReq.to = "/topics/" + topic;
            dataReq.notification = new notification();
            dataReq.notification.body = body;
            dataReq.notification.title = title;

            ServiceResult res = objToJson(dataReq, "");
            String val = res.ResultObjectJSON;
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(val);
            wr.flush();
            wr.close();

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return "Success";
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return "Success";
    }
}