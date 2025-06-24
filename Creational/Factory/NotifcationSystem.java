package Creational.Factory;
/*
 * 
 * The system should support sending a notification via:
   1. Email
   2. SMS
   3. Push Notification

All notification types should implement a common interface or abstract class (e.g., Notification) with a method:

You should create a Factory class that takes a String or enum input (like "EMAIL", "SMS", "PUSH") and returns the correct Notification object.

In your main() method, demonstrate sending a message via all three notification types using the factory.

 * 
 */
enum NotifcationType {
    EMAIL, SMS, PUSH_NOTIFICATION
}


public class NotifcationSystem {
    public static void main(String[] args) {
        
        Notification email = NotificationFactory.createNotification(NotifcationType.EMAIL);
        email.sendMessage("Hello from email");
        Notification sms  = NotificationFactory.createNotification(NotifcationType.SMS);
        sms.sendMessage("Hello from sms");
        Notification push  = NotificationFactory.createNotification(NotifcationType.PUSH_NOTIFICATION);
        push.sendMessage("Hello from push Notification");

    }

}
class NotificationFactory {

    public static Notification createNotification(NotifcationType type) {
        switch (type) {
            case EMAIL: return new Email();
            case SMS: return new SMS();
            case PUSH_NOTIFICATION: return new PushNotification();
        
            default:
                return null;
        }
    }
}

abstract class Notification {

    abstract void sendMessage(String message);
    
}

class Email extends Notification{
    @Override
    void sendMessage(String messgae) {
        // TODO Auto-generated method stub
        System.out.println("Sending Notification via Email : "+messgae);
        
    }
}

class SMS extends Notification{
    @Override
    void sendMessage(String messgae) {
        // TODO Auto-generated method stub
        System.out.println("Sending Notification via SMS : "+messgae);
        
    }
}

class PushNotification extends Notification{
    @Override
    void sendMessage(String messgae) {
        // TODO Auto-generated method stub
        System.out.println("Sending Notification via push notification : "+messgae);
        
    }
}

