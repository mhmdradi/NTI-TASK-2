package org.example;

public class InventoryServiceImpl implements InventoryService{
    @Override
    public int checkStock(String sku) {
        return 100;
    };
    @Override
   public void reserveStock(String sku,int qty){
        if(qty>100){
            throw new  IllegalStateException("not enough stock");
        }
        System.out.println(
                "Reserved " + qty + " units of " + sku
        );
    }
}
