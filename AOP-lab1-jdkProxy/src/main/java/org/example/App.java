package org.example;

import java.lang.reflect.Proxy;


public class App 
{
    public static void main( String[] args )
    {
        NotificationService target=new NotificationServiceImpl();
        NotificationService proxy =
                (NotificationService) Proxy.newProxyInstance(
                        NotificationService.class.getClassLoader(),
                        new Class<?>[] { NotificationService.class },
                        new LogProxy(target)
                );

    proxy.sendEmail("Student@example.com","welcome");
    proxy.sendSms("Student@example.com","welcome");
    }
}
