package com.example.l2;

import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Scope("prototype")
public class Card {

    private final ProductRepository productRepository;

    private final Map<Integer, Product> productList = new HashMap<>();


    public void put(int id)
    {
        var product = productRepository.get(id);
        if(product == null) throw new IndexOutOfBoundsException();

        productList.put(id, product);
    }

    public void remove(int id)
    {
        productList.remove(id);
    }

    public int count()
    {
        return productList.size();
    }


}
