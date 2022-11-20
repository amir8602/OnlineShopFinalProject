package ir.sae.onlineshop.models.product;


import ir.sae.onlineshop.models.Audit;
import ir.sae.onlineshop.models.orderItem.OrderItemEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity extends Audit{


    @Id
    @Column(updatable = false,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private BigDecimal productPrice;


    @Column(name ="number")
    private Integer unitInStock;


    @OneToMany(mappedBy = "productEntity")
    List<OrderItemEntity> orderItemEntityList;

    @Column(name = "image_path")
    private String imagePath;


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

    public List<OrderItemEntity> getOrderItemEntityList() {
        return orderItemEntityList;
    }

    public void setOrderItemEntityList(List<OrderItemEntity> orderItemEntityList) {
        this.orderItemEntityList = orderItemEntityList;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public ProductEntity(Long id, String productName, BigDecimal productPrice, Integer unitInStock, List<OrderItemEntity> orderItemEntityList, String imagePath) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.unitInStock = unitInStock;
        this.orderItemEntityList = orderItemEntityList;
        this.imagePath = imagePath;
    }

    public ProductEntity() {
    }
}
