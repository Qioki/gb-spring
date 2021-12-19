package com.example.l2;

import lombok.var;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Client {
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));


        ProductRepository repository = context.getBean(ProductRepository.class);
        Card card = context.getBean(Card.class);

        card.put(0);
        card.put(2);


        System.out.println("Products:");
        var list = repository.getList();
        list.forEach(p -> System.out.println(p.getId() + " - " + p.getTitle() + " - " + p.getPrice()));

        var scanner = new Scanner(System.in);


        int next = 0;

        while(true)
        {
            System.out.printf("You have %s product(s)", card.count());
            System.out.println();
            System.out.println("Input 'add id' or 'remove id' or -1");

            var nextLine = scanner.nextLine();

            if(Objects.equals(nextLine, "-1")) break;


            var command = nextLine.split(" ");

            if(command.length != 2) {
                System.out.println("Error command");
                continue;
            }



            try{
                int number = Integer.parseInt(command[1]);

                if(command[0].equals("add"))
                    card.put(number);

                else if(command[0].equals("remove"))
                    card.remove(number);


            }
            catch (NumberFormatException ex){ ex.printStackTrace(); }

        }

        context.close();
    }
}
