package ir.sae.onlineshop.dto;

import ir.sae.onlineshop.base.BaseDto;
import ir.sae.onlineshop.entities.OrderEntity;
import ir.sae.onlineshop.entities.ProductEntity;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

public class OrderItemDto extends BaseDto<Long> {



    @NotNull
    @Range(min = 0)
    private Integer quantity;

    private Double totalPrice;

    private ProductEntity productEntity;

    @NotNull
    private OrderEntity orderEntity;

    public OrderItemDto(Long id, int quantity, double totalPrice, ProductEntity productEntity, OrderEntity orderEntity) {
        super(id);
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.productEntity = productEntity;
        this.orderEntity = orderEntity;
    }

    public OrderItemDto() {
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
