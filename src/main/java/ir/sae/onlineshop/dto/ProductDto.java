package ir.sae.onlineshop.dto;

import ir.sae.onlineshop.base.BaseDto;
import ir.sae.onlineshop.entities.OrderItemEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
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

    private List<OrderItemEntity> orderItemList;

    private Long fileId;

    public ProductDto(Integer version, Date createDate, Date updateDate) {
        super(version, createDate, updateDate);
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

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public List<OrderItemEntity> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItemEntity> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
