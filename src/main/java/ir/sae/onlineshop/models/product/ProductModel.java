package ir.sae.onlineshop.models.product;

import ir.sae.onlineshop.models.orderItem.OrderItemEntity;

import java.math.BigDecimal;
import java.util.List;


public class ProductModel  {



    private Long id;

    private String productName;

    private BigDecimal productPrice;

    private Integer unitInStock;

    List<OrderItemEntity> orderItemEntityList;

    private String imagePath;


    public ProductModel(Long id, String productName, BigDecimal productPrice, Integer unitInStock, List<OrderItemEntity> orderItemEntityList, String imagePath) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.unitInStock = unitInStock;
        this.orderItemEntityList = orderItemEntityList;
        this.imagePath = imagePath;
    }

    public ProductModel(Long id) {
        this.id = id;
    }

    public ProductModel(String productName, BigDecimal productPrice, Integer unitInStock, List<OrderItemEntity> orderItemEntityList, String imagePath) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.unitInStock = unitInStock;
        this.orderItemEntityList = orderItemEntityList;
        this.imagePath = imagePath;
    }

    public ProductModel() {
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
}
