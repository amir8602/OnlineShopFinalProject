package ir.sae.onlineshop.models.orderItem;


import ir.sae.onlineshop.models.order.OrderModel;
import ir.sae.onlineshop.models.product.ProductModel;

public class OrderItemModel {



    private Long id;


    private int quantity;



    private double totalPrice;


    private OrderModel orderModel;



    ProductModel productModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderModel getOrderModel() {
        return orderModel;
    }

    public void setOrderModel(OrderModel orderModel) {
        this.orderModel = orderModel;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }

    public OrderItemModel(Long id, int quantity, double totalPrice, OrderModel orderModel, ProductModel productModel) {
        this.id = id;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderModel = orderModel;
        this.productModel = productModel;
    }

    public OrderItemModel() {
    }

    public OrderItemModel(int quantity, double totalPrice, OrderModel orderModel, ProductModel productModel) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderModel = orderModel;
        this.productModel = productModel;
    }
}
