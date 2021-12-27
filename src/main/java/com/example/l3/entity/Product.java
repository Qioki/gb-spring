package com.example.l3.entity;

import lombok.*;

@Setter@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product
{
    private Integer id;
    private String title;
    private Integer price;
}
