package ir.sae.onlineshop.dto;

import ir.sae.onlineshop.base.BaseDto;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class OrderItemDto extends BaseDto {



    @NotNull
    @Range(min = 0)
    private Integer quantity;

    private Double totalPrice;

    private ProductDto product;




    public OrderItemDto(Integer version, Date createDate, Date updateDate, Integer quantity, Double totalPrice, ProductDto product ) {
        super(version, createDate, updateDate);
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;

    }

    public OrderItemDto(Integer quantity, Double totalPrice, ProductDto product) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;

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

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }


}
