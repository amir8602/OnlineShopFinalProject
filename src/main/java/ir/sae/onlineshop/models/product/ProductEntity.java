package ir.sae.onlineshop.models.product;



import ir.sae.onlineshop.models.Audit;

import ir.sae.onlineshop.models.image.FileDB;
import ir.sae.onlineshop.models.orderItem.OrderItemEntity;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity extends Audit {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String productName;



    @Range(min = 0)
    @Column(name = "price")
    private Double productPrice;


    @Range(min = 0)
    @Column(name = "number")
    private Integer unitInStock;

    @OneToMany(mappedBy = "productEntity")
    List<OrderItemEntity> orderItemEntityList;

    @OneToOne(cascade ={CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name ="file",referencedColumnName ="id")
    FileDB file;


    public FileDB getFile() {
        return file;
    }

    public void setFile(FileDB file) {
        this.file = file;
    }

    public ProductEntity(Long id) {
        this.id = id;
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



    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
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


    public ProductEntity() {
    }

    public ProductEntity(Long id, String productName, Double productPrice, Integer unitInStock, List<OrderItemEntity> orderItemEntityList) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.unitInStock = unitInStock;
        this.orderItemEntityList = orderItemEntityList;
    }

    public ProductEntity(String productName, Double productPrice, Integer unitInStock, List<OrderItemEntity> orderItemEntityList) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.unitInStock = unitInStock;
        this.orderItemEntityList = orderItemEntityList;
    }

}
