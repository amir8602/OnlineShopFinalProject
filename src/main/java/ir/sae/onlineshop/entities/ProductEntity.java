package ir.sae.onlineshop.entities;


import ir.sae.onlineshop.base.BaseEntity;
import ir.sae.onlineshop.dto.IsNotNull2;
import ir.sae.onlineshop.image.FileDB;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity extends BaseEntity {


    @Id
    @Column(updatable = false,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PRODUCT_NAME")
    @NotBlank(message = "user.product.name.not.blank" , groups = IsNotNull2.class)
    @Size(min = 3 , max = 12 , message = "user.product.name.invalid.size" , groups = IsNotNull2.class)
    private String productName;

    @Column(name = "PRICE")
    @NotNull(groups = IsNotNull2.class)
    @Range(min = 0 , groups = IsNotNull2.class)
    private BigDecimal productPrice;


    @Column(name ="COUNT")
    @NotNull(groups = IsNotNull2.class)
    @Range(min = 0 , groups = IsNotNull2.class)
    private Integer unitInStock;


    @OneToMany(mappedBy = "product")
    List<OrderItemEntity> orderItem;


    @OneToOne(cascade = {CascadeType.REFRESH , CascadeType.MERGE})
    private FileDB file;

    public ProductEntity(ProductBuilder productBuilder) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<OrderItemEntity> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<OrderItemEntity> orderItemEntityList) {
        this.orderItem = orderItemEntityList;
    }


    public FileDB getFile() {
        return file;
    }

    public void setFile(FileDB file) {
        this.file = file;
    }

    public ProductEntity() {
    }

    public ProductEntity(Long id) {
        this.id = id;
    }

    public ProductEntity(Long id, String productName, BigDecimal productPrice, Integer unitInStock, List<OrderItemEntity> orderItem, FileDB file) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.unitInStock = unitInStock;
        this.orderItem = orderItem;
        this.file = file;
    }
}
