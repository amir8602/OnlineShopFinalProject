package ir.sae.onlineshop.apis;

import ir.sae.onlineshop.base.BaseController;
import ir.sae.onlineshop.dto.ProductDto;
import ir.sae.onlineshop.entities.ProductEntity;
import ir.sae.onlineshop.image.FileStorageService;
import ir.sae.onlineshop.mappers.ProductMapper;
import ir.sae.onlineshop.services.ProductService;
import ir.sae.onlineshop.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController extends BaseController<ProductDto,ProductEntity,
        ProductMapper, ProductServiceImpl> {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private FileStorageService imageService;

    public ProductRestController(ProductServiceImpl service, ProductMapper mapper) {
        super(service, mapper);
    }


    //create
//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping
//    public ProductDto saveProduct(@RequestBody ProductDto productDto){
//        ProductEntity productEntity = productMapper.dtoToEntityConvertor(productDto);
//        FileDB image = imageService.getFile(productDto.getFileId());
//        productEntity.setFile(image);
//        ProductEntity productEntity1 = productService.saveProduct(productEntity);
//        ProductDto productDto1 = productMapper.entityToDtoConvertor(productEntity1);
//        productDto1.setFileId(productDto.getFileId());
//        return productDto1;
//        //return productMapper.entityToModel(productService.saveProduct());
//    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping("/search-by-example")
    public List<ProductDto> searchByExample(@RequestBody ProductDto productDto){
        return productMapper.entityToDtoConvertor(productService.searchByExample(Example.of(productMapper.dtoToEntityConvertor(productDto))));
    }


    //read
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/{id}")
//    public ProductDto getById(@PathVariable("id") Long id){
//        return productMapper.entityToDtoConvertor(productService.getById(productMapper.dtoToEntityConvertor(new ProductDto(id))));
//    }
//
//    //read all
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//    @GetMapping
////    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public List<ProductDto> getAll(){
//        return productMapper.entityToDtoConvertor(productService.getAll());
//    }
//
//    //delete
//    @PreAuthorize("hasRole('ADMIN')")
//    @DeleteMapping("/{id}")
//    public String deleteById(@PathVariable("id") Long id){
//        try{
//            productService.delete(new ProductEntity(id));
//            return "Product Deleted !!!";
//        }catch (RuntimeException runtimeException){
//            return "Product Not Found";
//        }
//    }

    //update
//    @PutMapping
//    @PreAuthorize("hasRole('ADMIN')")
//    public ProductDto update(@RequestBody ProductDto productDto){
//        return productMapper.entityToDtoConvertor(productService.update(productMapper.dtoToEntityConvertor(productDto)));
//
//    }

}
