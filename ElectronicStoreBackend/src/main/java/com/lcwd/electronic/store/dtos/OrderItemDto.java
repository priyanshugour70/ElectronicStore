package com.lcwd.electronic.store.dtos;

import com.lcwd.electronic.store.entities.Order;
import com.lcwd.electronic.store.entities.Product;
import lombok.*;

import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItemDto {


    private int orderItemId;

    private int quantity;

    private int totalPrice;

    private ProductDto product;


}
