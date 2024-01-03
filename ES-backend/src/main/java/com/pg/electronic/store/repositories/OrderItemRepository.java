package com.pg.electronic.store.repositories;

import com.pg.electronic.store.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>
{
}
