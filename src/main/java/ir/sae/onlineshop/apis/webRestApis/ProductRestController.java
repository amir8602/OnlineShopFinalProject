package ir.sae.onlineshop.apis.webRestApis;

import ir.sae.onlineshop.mappers.ProductMapper;
import ir.sae.onlineshop.models.product.ProductModel;
import ir.sae.onlineshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    //create
    @PostMapping
    public ProductModel saveProduct(@RequestBody ProductModel productModelFromClient){
        return productMapper.entityToModel(productService.saveProduct(productMapper.modelToEntity(productModelFromClient)));
    }

    //read
    @GetMapping("/{id}")
    public ProductModel getById(@PathVariable("id") Long id){
        return productMapper.entityToModel(productService.getById(productMapper.modelToEntity(new ProductModel(id))));
    }

    //read all
    @GetMapping
    public List<ProductModel> getAll(){
        return productMapper.entityListToModelList(productService.getAll());
    }

    //delete
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
    }

    //update
    @PutMapping
    public ProductModel update(@RequestBody ProductModel productModel){
        return null;
    }

}
