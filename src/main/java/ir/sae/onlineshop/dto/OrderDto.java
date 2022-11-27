package ir.sae.onlineshop.dto;


import ir.sae.onlineshop.base.BaseDto;
import ir.sae.onlineshop.enums.OrderStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class OrderDto extends BaseDto {


    private Double grandTotal;


    @NotNull
    private UserDto user;


    private List<OrderItemDto> orderItems;


    @NotNull
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;




    public OrderDto() {
    }

    public OrderDto(Integer version, Date createDate, Date updateDate, Double grandTotal, UserDto user, List<OrderItemDto> orderItems, OrderStatus orderStatus) {
        super(version, createDate, updateDate);
        this.grandTotal = grandTotal;
        this.user = user;
        this.orderItems = orderItems;
        this.orderStatus = orderStatus;
    }

    public OrderDto(Double grandTotal, UserDto user, List<OrderItemDto> orderItems, OrderStatus orderStatus) {
        this.grandTotal = grandTotal;
        this.user = user;
        this.orderItems = orderItems;
        this.orderStatus = orderStatus;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }
}
