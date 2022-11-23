package ir.sae.onlineshop.models.order;


import ir.sae.onlineshop.models.orderItem.OrderItemModel;
import ir.sae.onlineshop.models.user.UserModel;

import java.util.List;


public class OrderModel {


    private Long id;


    private double grandTotal;


    List<OrderItemModel> orderItemModels;


    private UserModel userModel;


    OrderStatus orderStatus;


    public List<OrderItemModel> getOrderItemModels() {
        return orderItemModels;
    }

    public void setOrderItemModels(List<OrderItemModel> orderItemModels) {
        this.orderItemModels = orderItemModels;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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



    public OrderModel() {
    }

    public OrderModel(Long id, double grandTotal, List<OrderItemModel> orderItemModels, UserModel userModel, OrderStatus orderStatus) {
        this.id = id;
        this.grandTotal = grandTotal;
        this.orderItemModels = orderItemModels;
        this.userModel = userModel;
        this.orderStatus = orderStatus;
    }

    public OrderModel(double grandTotal, List<OrderItemModel> orderItemModels, UserModel userModel, OrderStatus orderStatus) {
        this.grandTotal = grandTotal;
        this.orderItemModels = orderItemModels;
        this.userModel = userModel;
        this.orderStatus = orderStatus;
    }
}
