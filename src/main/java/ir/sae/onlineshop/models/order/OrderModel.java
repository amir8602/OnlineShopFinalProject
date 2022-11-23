package ir.sae.onlineshop.models.order;

import ir.sae.onlineshop.models.orderItem.OrderItemModel;
import ir.sae.onlineshop.models.user.UserModel;

import java.util.List;

public class OrderModel {


    private Long id;


    private double grandTotal;


    private UserModel userModel;


    List<OrderItemModel> orderItemModels;


    private OrderStatus orderStatus;


    public OrderModel(Long id, double grandTotal, UserModel userModel, List<OrderItemModel> orderItemModels, OrderStatus orderStatus) {
        this.id = id;
        this.grandTotal = grandTotal;
        this.userModel = userModel;
        this.orderItemModels = orderItemModels;
        this.orderStatus = orderStatus;
    }

    public OrderModel() {
    }

    public OrderModel(double grandTotal, UserModel userModel, List<OrderItemModel> orderItemModels, OrderStatus orderStatus) {
        this.grandTotal = grandTotal;
        this.userModel = userModel;
        this.orderItemModels = orderItemModels;
        this.orderStatus = orderStatus;
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

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public List<OrderItemModel> getOrderItemModels() {
        return orderItemModels;
    }

    public void setOrderItemModels(List<OrderItemModel> orderItemModels) {
        this.orderItemModels = orderItemModels;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                "id=" + id +
                ", grandTotal=" + grandTotal +
                ", userModel=" + userModel +
                ", orderItemModels=" + orderItemModels +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
