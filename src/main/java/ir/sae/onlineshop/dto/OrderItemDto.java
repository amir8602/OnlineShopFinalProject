package ir.sae.onlineshop.dto;

import ir.sae.onlineshop.base.BaseDto;
import ir.sae.onlineshop.entities.OrderEntity;
import ir.sae.onlineshop.entities.ProductEntity;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class OrderItemDto extends BaseDto {



    @NotNull
    @Range(min = 0)
    private Integer quantity;

    private Double totalPrice;

    private ProductEntity product;

    @NotNull
    private OrderEntity order;


    public OrderItemDto(Integer version, Date createDate, Date updateDate, Integer quantity, Double totalPrice, ProductEntity product, OrderEntity order) {
        super(version, createDate, updateDate);
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
        this.order = order;
    }

    public OrderItemDto(Integer quantity, Double totalPrice, ProductEntity product, OrderEntity order) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
        this.order = order;
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

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}
