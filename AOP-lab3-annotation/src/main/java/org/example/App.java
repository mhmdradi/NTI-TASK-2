package org.example;

import org.example.InventoryService;
import org.example.ProductService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        try (var context = new AnnotationConfigApplicationContext()) {

            // Use "four" for the first four annotations.
            // Change to "around" to use only the around advice.
            context.getEnvironment().setActiveProfiles("four");

            context.register(AppConfig.class);
            context.refresh();

            InventoryService inventory =
                    context.getBean(InventoryService.class);

            System.out.println("\n=== SUCCESS WITH RESULT ===");
            int stock = inventory.checkStock("SKU-1");
            System.out.println("CALLER: stock=" + stock);

            System.out.println("\n=== SUCCESS WITH VOID ===");
            inventory.reserveStock("SKU-1", 10);

            System.out.println("\n=== EXCEPTION ===");

            try {
                inventory.reserveStock("SKU-1", 150);
            } catch (IllegalStateException ex) {
                System.out.println(
                        "CALLER caught: " + ex.getMessage()
                );
            }

            System.out.println("\n=== CUSTOM CACHE ===");

            ProductService products =
                    context.getBean(ProductService.class);

            System.out.println(products.getProduct("P1"));
            System.out.println(products.getProduct("P1"));
            System.out.println(products.getProduct("P2"));

            System.out.println(
                    "Actual loads: " + products.getLoadCount()
            );
        }
    }
}