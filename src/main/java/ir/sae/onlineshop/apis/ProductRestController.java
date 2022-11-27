package ir.sae.onlineshop.apis;

import ir.sae.onlineshop.base.BaseRestController;
import ir.sae.onlineshop.dto.ProductDto;
import ir.sae.onlineshop.entities.ProductEntity;
import ir.sae.onlineshop.image.FileStorageService;
import ir.sae.onlineshop.mappers.ProductMapper;
import ir.sae.onlineshop.services.ProductService;
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
public class ProductRestController extends BaseRestController<
        ProductDto, ProductEntity, ProductMapper, ProductService, Long> {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private FileStorageService imageService;

    public ProductRestController(ProductService service, ProductMapper mapper) {
        super(service, mapper);
    }


//
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
//
//    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping("/search")
    public List<ProductDto> search(@RequestBody ProductDto productDto){
        return productMapper.entityToDtoConvertor(productService.search(Example.of(productMapper.dtoToEntityConvertor(productDto))));
    }


//
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
//    public void deleteById(@PathVariable("id") Long id) {
//
//        productService.delete(new ProductEntity(id));
//
//    }
//
//
//    @PutMapping
//    @PreAuthorize("hasRole('ADMIN')")
//    public ProductDto update(@RequestBody ProductDto productDto){
//        return productMapper.entityToDtoConvertor(productService.update(productMapper.dtoToEntityConvertor(productDto)));
//
//    }

}
