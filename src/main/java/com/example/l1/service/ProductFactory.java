package com.example.l1.service;

import com.example.l1.entity.Product;
import lombok.var;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductFactory {


    public Product getProduct(int id, String title, int cost){
        return new Product(id, title, cost);
    }
    public List<Product> getTestProducts(int count){
//        var products = new Product[count];
        var products = new ArrayList<Product>();

        var r = new Random();

        for (int i = 0; i < count; i++) {
            products.add(new Product(i, "Product" + i, r.nextInt(900) + 99));
//            System.out.println(products.get(i).getTitle());
        }

        return products;
    }
}
