package ir.sae.onlineshop.models.orderItem;


import ir.sae.onlineshop.models.order.OrderEntity;
import ir.sae.onlineshop.models.product.ProductEntity;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItemEntity {


    @Id
    @Column(nullable = false , updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name ="number")
    private int quantity;


    @Column(name ="price")
    private double totalPrice;


    @ManyToOne
    @JoinColumn(name = "product" , referencedColumnName = "id")
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "order" ,referencedColumnName = "id")
    private OrderEntity orderEntity;


    public OrderItemEntity(Long id, int quantity, double totalPrice, ProductEntity productEntity, OrderEntity orderEntity) {
        this.id = id;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.productEntity = productEntity;
        this.orderEntity = orderEntity;
    }

    public OrderItemEntity() {
    }


    public OrderItemEntity(int quantity, double totalPrice, ProductEntity productEntity, OrderEntity orderEntity) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.productEntity = productEntity;
        this.orderEntity = orderEntity;
    }


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

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }
}
