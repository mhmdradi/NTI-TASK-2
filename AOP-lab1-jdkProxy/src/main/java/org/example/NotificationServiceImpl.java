package org.example;

public class NotificationServiceImpl implements NotificationService {
@Override
    public void sendSms(String to,String message) {
    System.out.println("Email to " + to + " sent to " + message);
}
@Override
    public void sendEmail(String to,String message) {
    System.out.println("Email to " + to + " sent to " + message);
    }

}
