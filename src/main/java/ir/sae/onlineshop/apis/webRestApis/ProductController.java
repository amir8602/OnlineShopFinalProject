package ir.sae.onlineshop.apis.webRestApis;

import ir.sae.onlineshop.mappers.ProductMapper;
import ir.sae.onlineshop.models.image.FileDB;
import ir.sae.onlineshop.models.image.FileStorageService;
import ir.sae.onlineshop.models.product.ProductEntity;
import ir.sae.onlineshop.models.product.ProductModel;
import ir.sae.onlineshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    private FileStorageService fileStorageService;

    //create
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ProductModel saveProduct(@RequestBody ProductModel productModel) {

        ProductEntity productEntity = productMapper.modelToEntityConvertor(productModel);
        FileDB image = fileStorageService.getFile(productModel.getFileId());
        productEntity.setFile(image);
        ProductEntity saveProductEntity = productService.saveProduct(productEntity);
        ProductModel saveProductModel = productMapper.entityToModelConvertor(saveProductEntity);
        saveProductModel.setFileId(productModel.getFileId());
        return saveProductModel;

    }

    //read
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ProductModel getById(@PathVariable("id") Long id) {
        ProductEntity productEntity = new ProductEntity(id);
        ProductEntity getProductEntity = productService.getById(productEntity);
        ProductModel productModel = productMapper.entityToModelConvertor(getProductEntity);
        return productModel;

    }

    //read all
    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<ProductModel> getAll() {

        List<ProductEntity> getProducts = productService.getAll();
        List<ProductModel> productModels = productMapper.entityToModelConvertor(getProducts);
        return productModels;


    }

    //delete
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteById(@PathVariable("id") Long id) {

        ProductEntity productEntity = new ProductEntity(id);

        try {
            productService.deleteProduct(productEntity.getId());
        } catch (Exception e) {
            return "product is not found!";
        }
        return "product remove of order Successfully!";
    }

    //update
    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ProductModel update(@RequestBody ProductModel productModel) {
        ProductEntity productEntity = productMapper.modelToEntityConvertor(productModel);
        ProductEntity updateEntity = productService.updateProduct(productEntity);
        ProductModel updateModel = productMapper.entityToModelConvertor(updateEntity);
        return updateModel;
    }

}




