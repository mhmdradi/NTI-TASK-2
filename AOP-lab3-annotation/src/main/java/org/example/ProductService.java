package org.example;


import org.example.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private int loadCount;

    @Cacheable
    public String getProduct(String id) {

        loadCount++;

        System.out.println(
                "TARGET: loading product " + id
        );

        return "Product: " + id;
    }

    public int getLoadCount() {
        return loadCount;
    }
}