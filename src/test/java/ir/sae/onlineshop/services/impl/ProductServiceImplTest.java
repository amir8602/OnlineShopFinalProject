package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.OnlineShopApplication;
import ir.sae.onlineshop.entities.ProductEntity;
import ir.sae.onlineshop.repositories.ProductRepository;
import ir.sae.onlineshop.services.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = OnlineShopApplication.class)
@EnableTransactionManagement
class ProductServiceImplTest {


    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        ProductEntity productEntity=new ProductEntity();
        productEntity.setProductName("wer");
        productEntity.setUnitInStock(12);
        productService.saveProduct(productEntity);
        ProductEntity productEntity2=new ProductEntity();
        productEntity2.setProductName("ewq");
        productEntity2.setUnitInStock(12);
        productService.saveProduct(productEntity2);
        ProductEntity productEntity3=new ProductEntity();
        productEntity3.setProductName("trw");
        productEntity3.setUnitInStock(12);
        productService.saveProduct(productEntity3);
    }

    @AfterEach
    void tearDown() {
        productRepository.deleteAll();
    }

    @Test
    void saveProduct() {
        ProductEntity productEntity=new ProductEntity();
        productEntity.setProductName("Laptop");
        productEntity.setUnitInStock(12);
        ProductEntity productEntity1 = productService.saveProduct(productEntity);

        ProductEntity byId = productService.getById(productEntity1);

        assertEquals(byId.getId(),productEntity1.getId());
    }

//    @Test
//    void getById() {
//        ProductEntity byId = productService.getById(new ProductEntity(1L));
//        System.out.println("-------------------------------------------"+byId.getProductName()+"-------------------------------------------");
//        assertNotNull(byId.getProductName());
//    }

    @Test
    void getByIdNotExist() {
        assertThrows(NullPointerException.class,() ->
                productService.getById(null));
    }

    @Test
    void getAll() {
        List<ProductEntity> all = productService.getAll();

        assertEquals(3,all.size());

    }

    @Test
    void update() {
        ProductEntity productEntity=new ProductEntity();
        productEntity.setId(3L);
        productEntity.setProductName("Laptop");
        productEntity.setUnitInStock(12);

        ProductEntity update = productService.update(productEntity);

        assertNotEquals("ewq",update.getProductName());
    }

//    @Test
//    void delete() {
//    }

    @Test
    void searchByExample() {
        ProductEntity productEntity=new ProductEntity();
        productEntity.setProductName("wer");
        List<ProductEntity> productEntities = productService.searchByExample(Example.of(productEntity));
        assertNotNull(productEntities);
    }
}