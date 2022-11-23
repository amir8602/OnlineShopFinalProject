package ir.sae.onlineshop.models.product;



import ir.sae.onlineshop.models.orderItem.OrderItemEntity;

import java.util.List;


public class ProductModel  {

    private Long id;
    private String productName;

    private Double productPrice;


    private Integer unitInStock;

    List<OrderItemEntity> orderItemEntityList;

    private Long fileId;

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

    public ProductModel(Long id, String productName, Double productPrice, Integer unitInStock, List<OrderItemEntity> orderItemEntityList, Long fileId) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.unitInStock = unitInStock;
        this.orderItemEntityList = orderItemEntityList;
        this.fileId = fileId;
    }

    public ProductModel(String productName) {
        this.productName = productName;
    }

    public ProductModel(String productName, Double productPrice, Integer unitInStock, List<OrderItemEntity> orderItemEntityList, Long fileId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.unitInStock = unitInStock;
        this.orderItemEntityList = orderItemEntityList;
        this.fileId = fileId;
    }

    public ProductModel(Long id, String productName, Double productPrice, Integer unitInStock, Long fileId) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.unitInStock = unitInStock;
        this.fileId = fileId;
    }

    public ProductModel() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
