package com.example.gbsb;

import com.example.gbsb.Entity.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Component
@Scope("prototype")
public class Cart implements Consumer<Product> {

    private final Map<Integer, ArrayList<Product>> products = new HashMap<>();

    public void add(Product product){
        var p = products.get(product.getId());
        if(p == null) {
            p = new ArrayList<>();
            products.put(product.getId(), p);
        }
        p.add(product);
//        products.put(product.getId(), product);
    }

    public void deleteByProductId(Integer id){
        var p = products.get(id);
        if(p != null && p.size() > 0) {
            p.remove(0);
        }
//        products.remove(id);
    }
    public void showProductList(){
        System.out.println(products);
    }


    @Override
    public void accept(Product product) {
        add(product);
    }
}
