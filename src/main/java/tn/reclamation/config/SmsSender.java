package tn.reclamation.config;


public interface SmsSender {


    void sendSms(SmsRequest smsRequest);

    // or maybe void sendSms(String phoneNumber, String message);
}
