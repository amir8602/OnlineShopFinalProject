package ir.sae.onlineshop.entities;


import ir.sae.onlineshop.base.BaseEntity;
import ir.sae.onlineshop.dto.IsNotNull2;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ORDER_ITEM")
public class OrderItemEntity extends BaseEntity {


    @Id
    @Column(nullable = false , updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name ="COUNT")
    @NotNull(groups = IsNotNull2.class)
    @Range(min = 0,groups = IsNotNull2.class)
    private Integer quantity;


    @Column(name ="PRICE")
    private Double totalPrice;


    @ManyToOne
    private ProductEntity product;

    @ManyToOne
    private OrderEntity order;


    public OrderItemEntity(Long id, int quantity, double totalPrice, ProductEntity product, OrderEntity order) {
        this.id = id;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
        this.order = order;
    }

    public OrderItemEntity() {
    }


    public OrderItemEntity(int quantity, double totalPrice, ProductEntity product, OrderEntity order) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
        this.order = order;
    }

    public OrderItemEntity(Long id, Integer quantity, Double totalPrice, ProductEntity product) {
        this.id = id;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
    }

    public OrderItemEntity(Long id) {
        this.id = id;
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

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity productEntity) {
        this.product = productEntity;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity orderEntity) {
        this.order = orderEntity;
    }
}
