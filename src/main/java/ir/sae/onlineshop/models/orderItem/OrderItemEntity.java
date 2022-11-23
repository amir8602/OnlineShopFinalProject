package ir.sae.onlineshop.models.orderItem;


import ir.sae.onlineshop.models.order.OrderEntity;
import ir.sae.onlineshop.models.product.ProductEntity;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

@Entity
@Table(name ="order_item")
public class OrderItemEntity {


    @Id
    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Range(min = 0)
    @Column(name ="number")
    private int quantity;


    @Column(name ="price")
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "order",referencedColumnName ="id")
    private OrderEntity orderEntity;


    @ManyToOne
    @JoinColumn(name = "product",referencedColumnName ="id")
    ProductEntity productEntity;


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

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public OrderItemEntity(Long id, int quantity, double totalPrice, OrderEntity orderEntity, ProductEntity productEntity) {
        this.id = id;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderEntity = orderEntity;
        this.productEntity = productEntity;
    }

    public OrderItemEntity() {
    }

    public OrderItemEntity(int quantity, double totalPrice, OrderEntity orderEntity, ProductEntity productEntity) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderEntity = orderEntity;
        this.productEntity = productEntity;
    }

}
