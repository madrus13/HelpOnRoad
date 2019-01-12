package ru.Service;

public class FcmNotifyRequest {

    public String to;
    public data data;
    public notification notification;
}



class notification {
    public String title;
    public String body;

}
class data {
    public String message;
}



