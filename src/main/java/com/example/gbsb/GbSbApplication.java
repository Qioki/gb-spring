package com.example.gbsb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableConfigurationProperties(ProductProps.class)
@SpringBootApplication
public class  GbSbApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(GbSbApplication.class, args);


        for (int i = 0; i < 5; i++) {
            Buyer buyer = context.getBean(Buyer.class);
            buyer.purchase();
            buyer.showCard();
        }
    }

}
