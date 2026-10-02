package org.example;

public interface InventoryService {
    int checkStock(String sku);
    void reserveStock(String sku,int qty);
}
