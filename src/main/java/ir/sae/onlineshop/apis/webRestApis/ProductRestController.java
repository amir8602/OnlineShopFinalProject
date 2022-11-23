package ir.sae.onlineshop.apis.webRestApis;

import ir.sae.onlineshop.mappers.ProductMapper;
import ir.sae.onlineshop.models.image.FileDB;
import ir.sae.onlineshop.models.image.FileStorageService;
import ir.sae.onlineshop.models.product.ProductEntity;
import ir.sae.onlineshop.models.product.ProductModel;
import ir.sae.onlineshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private FileStorageService imageService;




    //create
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ProductModel saveProduct(@RequestBody ProductModel productModel){
        ProductEntity productEntity = productMapper.modelToEntity(productModel);
        FileDB image = imageService.getFile(productModel.getFileId());
        productEntity.setFile(image);
        ProductEntity productEntity1 = productService.saveProduct(productEntity);
        ProductModel productModel1 = productMapper.entityToModel(productEntity1);
        productModel1.setFileId(productModel.getFileId());
        return productModel1;
        //return productMapper.entityToModel(productService.saveProduct());
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping("/search-by-example")
    public List<ProductModel> searchByExample(@RequestBody ProductModel productModel){
        return productMapper.entityListToModelList(productService.searchByExample(Example.of(productMapper.modelToEntity(productModel))));
    }


    //read
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ProductModel getById(@PathVariable("id") Long id){
        return productMapper.entityToModel(productService.getById(productMapper.modelToEntity(new ProductModel(id))));
    }

    //read all
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping
    public List<ProductModel> getAll(){
        return productMapper.entityListToModelList(productService.getAll());
    }

    //delete
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id){
        try{
            productService.delete(new ProductEntity(id));
            return "Product Deleted !!!";
        }catch (RuntimeException runtimeException){
            return "Product Not Found";
        }
    }

    //update
    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ProductModel update(@RequestBody ProductModel productModel){
        return productMapper.entityToModel(productService.update(productMapper.modelToEntity(productModel)));

    }

}
