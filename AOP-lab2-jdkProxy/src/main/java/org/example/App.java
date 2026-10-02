package org.example;

import org.springframework.aop.framework.ProxyFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        InventoryService target = new InventoryServiceImpl();

        ProxyFactory factory = new ProxyFactory(target);

        // أول واحدة عشان تغلف باقي التنفيذ وتقيس وقته
        factory.addAdvice(new TimingInterceptor());

        factory.addAdvice(new LoggingBeforeAdvice());
        factory.addAdvice(new LoggingAfterReturningAdvice());
        factory.addAdvice(new LoggingThrowsAdvice());

        InventoryService proxy =
                (InventoryService) factory.getProxy();

        // 1. ميثود بترجع قيمة
        int stock = proxy.checkStock("SKU-1");
        System.out.println("CALLER: stock = " + stock);

        // 2. حجز ناجح
        proxy.reserveStock("SKU-1", 20);

        // 3. حجز يفشل لأن الكمية أكبر من 100
        try {
            proxy.reserveStock("SKU-1", 150);

        } catch (IllegalStateException ex) {
            System.out.println(
                    "CALLER caught: " + ex.getMessage()
            );
        }
    }
}
