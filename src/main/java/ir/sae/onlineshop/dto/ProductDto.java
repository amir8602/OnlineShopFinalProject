package ir.sae.onlineshop.dto;

import ir.sae.onlineshop.base.BaseDto;
import ir.sae.onlineshop.entities.OrderItemEntity;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;


public class ProductDto extends BaseDto {



    @NotBlank(message = "user.product.name.not.blank")
    @Size(min = 3 , max = 12 , message = "user.product.name.invalid.size")
    private String productName;

    @NotNull
    @Range(min = 0)
    private BigDecimal productPrice;

    @NotNull
    @Range(min = 0)
    private Integer unitInStock;

    private List<OrderItemEntity> orderItemEntityList;

    private Long fileId;



    public ProductDto() {

    }



    public ProductDto(String productName, BigDecimal productPrice, Integer unitInStock, List<OrderItemEntity> orderItemEntityList, Long fileId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.unitInStock = unitInStock;
        this.orderItemEntityList = orderItemEntityList;
        this.fileId = fileId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(Integer unitInStock) {
        this.unitInStock = unitInStock;
    }

    public List<OrderItemEntity> getOrderItemEntityList() {
        return orderItemEntityList;
    }

    public void setOrderItemEntityList(List<OrderItemEntity> orderItemEntityList) {
        this.orderItemEntityList = orderItemEntityList;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

}
