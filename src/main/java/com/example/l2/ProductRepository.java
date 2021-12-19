package com.example.l2;

import lombok.var;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ProductRepository {

    private final List<Product> productList = new ArrayList<>();


    @PostConstruct
    public void init()
    {
        var r = new Random();
        var count = 5;

        for (int i = 0; i < count; i++) {
            add(new Product(i, "Product " + i, 99 + r.nextInt(900)));
        }
    }

    public void add(Product product) {
        productList.add(product);
    }

    public Product get(int id) {
        return productList.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }

    public List<Product> getList() {
        return productList;
    }
}
