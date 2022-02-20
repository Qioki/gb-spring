package com.example.gbsb;

import com.example.gbsb.Entity.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Configuration
@ConfigurationProperties("shop.properties")
@Getter
@Setter
public class ProductRepository {

    private List<Product> products;


    public Product save(Product product) {
        products.add(product);
        product.setId(products.size() - 1);
        return Product.builder()
                .id(product.getId())
                .title(product.getTitle())
                .price(product.getPrice())
                .build();
    }

    public void edit(Product product){
        products.set(product.getId(), product);
    }

    public Optional<Product> findById(Integer id){
        if(id >= 0&& id < (products.size()))
            return Optional.of(products.get(id));
        else
            return Optional.empty();

    }

    public Iterable<Product> findAll(){
        return new ArrayList<>(products);
    }

    public long count(){
        return products.size();
    }

    public void deleteById(int id)
    {
        if(id > 0 || id < products.size())
            products.remove(id);
    }
}
