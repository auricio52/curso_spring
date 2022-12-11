package com.empresa.course.entities;

import com.empresa.course.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    private static final Long serialVersionUID = 1L;

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private Double price;
    private Integer quantity;

    public OrderItem() { }

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.price = price;
        this.quantity = quantity;
    }

    // O nome do método inicia com get para que o resultado possa ser mapeado para um json
    public Double getSubTotal() {
        return price * quantity;
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public void setOrder(Order order) {
        id.setOrder(order);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        return id != null ? id.equals(orderItem.id) : orderItem.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
