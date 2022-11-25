package ir.sae.onlineshop.entities;

import java.math.BigDecimal;

public class ProductBuilder {



    private Long id;
    private String productName;
    private BigDecimal productPrice;
    private Integer unitInStock;


    public ProductBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ProductBuilder setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public ProductBuilder setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
        return this;
    }

    public ProductBuilder setUnitInStock(Integer unitInStock) {
        this.unitInStock = unitInStock;
        return this;
    }

    public ProductEntity build()
    {
        return new ProductEntity(this);
    }
}
