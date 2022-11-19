package ir.sae.onlineshop.models.product;


import com.sun.istack.internal.NotNull;
import ir.sae.onlineshop.models.Audit;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "Product")
public class ProductEntity extends Audit implements Serializable {


    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(name = "productName")
    private String productName;

    @NotNull
    @Range(min = 0)
    @Column(name = "price")
    private BigDecimal productPrice;

    @NotNull
    @Range(min = 0)
    @Column(name ="number")
    private Double unitInStock;


    @Transient
    private MultipartFile productImage;

    public Long getId() {
        return productId;
    }

    public void setId(Long id) {
        this.productId = id;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(Double unitInStock) {
        this.unitInStock = unitInStock;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }
}
