package org.example;

import org.springframework.stereotype.Service;

@Service
public class InventoryService {
public  int checkStock(String sku){
    System.out.println("Target : checking stck for " + sku);
    return 100;

}
public void reserveStock(String sku,int qty){
        if(qty <= 0) {
            throw new IllegalArgumentException(
"quantity must be greater than 0"            );
        }
        if (qty>100){
            throw new IllegalArgumentException("quantity must be less than 100");
        }
    System.out.println("Target : reserveStock for " + sku);
}
}
