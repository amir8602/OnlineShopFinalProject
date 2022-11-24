package ir.sae.onlineshop.models.order;

import ir.sae.onlineshop.models.Audit;
import ir.sae.onlineshop.models.orderItem.OrderItemEntity;
import ir.sae.onlineshop.models.user.UserEntity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "order")
public class OrderEntity extends Audit  {

    @Id
    @Column(updatable = false , nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(name ="cost")
    private double grandTotal;


    @OneToOne
    @JoinColumn(name = "user" , referencedColumnName = "id")
    private UserEntity userEntity;


    @OneToMany(mappedBy = "orderEntity" )
    List<OrderItemEntity> orderItemEntities ;


    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public OrderEntity(Long id) {
        this.id = id;
    }

    public OrderEntity(Long id, double grandTotal, UserEntity userEntity, List<OrderItemEntity> orderItemEntities, OrderStatus orderStatus) {
        this.id = id;
        this.grandTotal = grandTotal;
        this.userEntity = userEntity;
        this.orderItemEntities = orderItemEntities;
        this.orderStatus = orderStatus;
    }

    public OrderEntity(double grandTotal, UserEntity userEntity, List<OrderItemEntity> orderItemEntities, OrderStatus orderStatus) {
        this.grandTotal = grandTotal;
        this.userEntity = userEntity;
        this.orderItemEntities = orderItemEntities;
        this.orderStatus = orderStatus;
    }

    public OrderEntity(double grandTotal, UserEntity userEntity, OrderStatus orderStatus) {
        this.grandTotal = grandTotal;
        this.userEntity = userEntity;
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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public List<OrderItemEntity> getOrderItemEntities() {
        return orderItemEntities;
    }

    public void setOrderItemEntities(List<OrderItemEntity> orderItemEntities) {
        this.orderItemEntities = orderItemEntities;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", grandTotal=" + grandTotal +
                ", userEntity=" + userEntity +
                ", orderItemEntities=" + orderItemEntities +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
