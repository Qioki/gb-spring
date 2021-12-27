package com.example.l3.repository;

import com.example.l3.entity.Product;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {

    private final List<Product> productList = new ArrayList<>();

    public Product save(Product product) {
        productList.add(product);
        product.setId(productList.size() - 1);
        return Product.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .build();
    }

    public void edit(Product product){
        productList.set(product.getId(), product);
    }

    public Optional<Product> findById(int id)
    {
        if(id < productList.size())
            return Optional.ofNullable(productList.get(id));
        else
            return Optional.empty();
    }

    public Iterable<Product> findAll(){
        return new ArrayList<>(productList);
    }

    public long count(){
        return productList.size();
    }

    public void deleteById(int id)
    {
        if(id > 0 || id < productList.size())
            productList.remove(id);
    }
}
