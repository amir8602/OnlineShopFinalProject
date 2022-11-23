package ir.sae.onlineshop.models.order;

import ir.sae.onlineshop.models.Audit;
import ir.sae.onlineshop.models.orderItem.OrderItemEntity;
import ir.sae.onlineshop.models.user.UserEntity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "order")
public class OrderEntity extends Audit {

    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cost")
    private double grandTotal;

    @OneToMany(mappedBy = "orderEntity")
    List<OrderItemEntity> orderItemEntitySet;

    @OneToOne
    @JoinColumn(name = "user",referencedColumnName ="id")
    private UserEntity userEntity;


    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;


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

    public List<OrderItemEntity> getOrderItemEntitySet() {
        return orderItemEntitySet;
    }

    public void setOrderItemEntitySet(List<OrderItemEntity> orderItemEntitySet) {
        this.orderItemEntitySet = orderItemEntitySet;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderEntity(Long id, double grandTotal, List<OrderItemEntity> orderItemEntitySet, UserEntity userEntity, OrderStatus orderStatus) {
        this.id = id;
        this.grandTotal = grandTotal;
        this.orderItemEntitySet = orderItemEntitySet;
        this.userEntity = userEntity;
        this.orderStatus = orderStatus;
    }

    public OrderEntity(double grandTotal, List<OrderItemEntity> orderItemEntitySet, UserEntity userEntity, OrderStatus orderStatus) {
        this.grandTotal = grandTotal;
        this.orderItemEntitySet = orderItemEntitySet;
        this.userEntity = userEntity;
        this.orderStatus = orderStatus;
    }

    public OrderEntity() {
    }

    public OrderEntity(Long id, double grandTotal, UserEntity userEntity, OrderStatus orderStatus) {
        this.id = id;
        this.grandTotal = grandTotal;
        this.userEntity = userEntity;
        this.orderStatus = orderStatus;
    }
}
