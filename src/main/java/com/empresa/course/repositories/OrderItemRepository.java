package com.empresa.course.repositories;

import com.empresa.course.entities.OrderItem;
import com.empresa.course.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
