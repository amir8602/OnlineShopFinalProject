package ir.sae.onlineshop.models.product;

import ir.sae.onlineshop.models.orderItem.OrderItemEntity;

import java.math.BigDecimal;
import java.util.List;


public class ProductModel {



    private Long id;

    private String productName;

    private BigDecimal productPrice;

    private Integer unitInStock;

    List<OrderItemEntity> orderItemEntityList;

    private Long fileId;

    //find by id ----> imageEntity
    //product model --->  productEntity.setImage(imageEntity);


//    public ProductModel(Long id, String productName, BigDecimal productPrice, Integer unitInStock, List<OrderItemEntity> orderItemEntityList, Long imageId) {
//        this.id = id;
//        this.productName = productName;
//        this.productPrice = productPrice;
//        this.unitInStock = unitInStock;
//        this.orderItemEntityList = orderItemEntityList;
//        this.imageId = imageId;
//    }

    public ProductModel(Long id) {
        this.id = id;
    }

//    public ProductModel(String productName, BigDecimal productPrice, Integer unitInStock, List<OrderItemEntity> orderItemEntityList, Long imageId) {
//        this.productName = productName;
//        this.productPrice = productPrice;
//        this.unitInStock = unitInStock;
//        this.orderItemEntityList = orderItemEntityList;
//        this.imageId = imageId;
//    }

    //    public ProductModel(String productName, BigDecimal productPrice, Integer unitInStock, List<OrderItemEntity> orderItemEntityList, ImageEntity imageEntity) {
//        this.productName = productName;
//        this.productPrice = productPrice;
//        this.unitInStock = unitInStock;
//        this.orderItemEntityList = orderItemEntityList;
//        this.imageEntity = imageEntity;
//    }

    public ProductModel() {
    }

    public ProductModel(String productName, BigDecimal productPrice, Integer unitInStock, List<OrderItemEntity> orderItemEntityList, Long fileId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.unitInStock = unitInStock;
        this.orderItemEntityList = orderItemEntityList;
        this.fileId = fileId;
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

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    //    public Long getImageId() {
//        return imageId;
//    }
//
//    public void setImageId(Long imageId) {
//        this.imageId = imageId;
//    }

    //    public ImageEntity getImageEntity() {
//        return imageEntity;
//    }
//
//    public void setImageEntity(ImageEntity imageEntity) {
//        this.imageEntity = imageEntity;
//    }
}
