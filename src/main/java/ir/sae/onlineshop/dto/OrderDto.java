package ir.sae.onlineshop.dto;


import ir.sae.onlineshop.base.BaseDto;
import ir.sae.onlineshop.enums.OrderStatus;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class OrderDto extends BaseDto<Long> {


    private Double grandTotal;


    @NotNull
    private UserDto userDto;


    private List<OrderItemDto<Number>> orderItemDtos;


    @NotNull
    private OrderStatus orderStatus;




    public OrderDto() {
    }


    public OrderDto(Double grandTotal, UserDto userDto, List<OrderItemDto<Number>> orderItemDtos, OrderStatus orderStatus) {
        this.grandTotal = grandTotal;
        this.userDto = userDto;
        this.orderItemDtos = orderItemDtos;
        this.orderStatus = orderStatus;
    }

    public OrderDto(Long id, Date createDate, Date updateDate, Double grandTotal, UserDto userDto, List<OrderItemDto<Number>> orderItemDtos, OrderStatus orderStatus) {
        super(id);
        this.grandTotal = grandTotal;
        this.userDto = userDto;
        this.orderItemDtos = orderItemDtos;
        this.orderStatus = orderStatus;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public UserDto getUserModel() {
        return userDto;
    }

    public void setUserModel(UserDto userDto) {
        this.userDto = userDto;
    }

    public List<OrderItemDto<Number>> getOrderItemModels() {
        return orderItemDtos;
    }

    public void setOrderItemModels(List<OrderItemDto<Number>> orderItemDtos) {
        this.orderItemDtos = orderItemDtos;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }


}
