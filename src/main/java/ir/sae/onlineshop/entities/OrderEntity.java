package ir.sae.onlineshop.entities;

import ir.sae.onlineshop.base.BaseEntity;
import ir.sae.onlineshop.enums.OrderStatus;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "ORDER")
public class OrderEntity extends BaseEntity {

    @Id
    @Column(updatable = false , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name ="COST")
    private double grandTotal;


    @OneToOne
    @JoinColumn(name = "USER" , referencedColumnName = "id")
    private UserEntity user;


    @OneToMany(mappedBy = "order")
    List<OrderItemEntity> orderItem;


    @Enumerated(EnumType.STRING)
    @Column(name = "ORDER_STATUS")
    private OrderStatus orderStatus;


    public OrderEntity(double grandTotal, UserEntity user, List<OrderItemEntity> orderItem, OrderStatus orderStatus) {
        this.grandTotal = grandTotal;
        this.user = user;
        this.orderItem = orderItem;
        this.orderStatus = orderStatus;
    }

    public OrderEntity(Long id) {
        this.id = id;
    }

    public OrderEntity(Long id, double grandTotal, UserEntity user, List<OrderItemEntity> orderItem, OrderStatus orderStatus) {
        this.id = id;
        this.grandTotal = grandTotal;
        this.user = user;
        this.orderItem = orderItem;
        this.orderStatus = orderStatus;
    }

    public OrderEntity() {
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity userEntity) {
        this.user = userEntity;
    }

    public List<OrderItemEntity> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<OrderItemEntity> orderItemEntities) {
        this.orderItem = orderItemEntities;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}