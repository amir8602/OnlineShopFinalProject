package ir.sae.onlineshop.apis;

import ir.sae.onlineshop.dto.ProductDto;
import ir.sae.onlineshop.entities.ProductEntity;
import ir.sae.onlineshop.exceptions.BaseException;
import ir.sae.onlineshop.image.FileDB;
import ir.sae.onlineshop.image.FileStorageService;
import ir.sae.onlineshop.mappers.ProductMapper;
import ir.sae.onlineshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController{

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private FileStorageService imageService;



    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ProductDto saveProduct(@RequestBody ProductDto productDto) throws BaseException {
        ProductEntity productEntity = productMapper.dtoToEntityConvertor(productDto);
        FileDB image = imageService.getFile(productDto.getFileId());
        productEntity.setFile(image);
        ProductEntity productEntity1 = productService.saveProduct(productEntity);
        ProductDto productDto1 = productMapper.entityToDtoConvertor(productEntity1);
        productDto1.setFileId(productDto.getFileId());
        return productDto1;
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping("/search-by-example")
    public List<ProductDto> searchByExample(@RequestBody ProductDto productDto) throws BaseException {
        return productMapper.entityToDtoConvertor(productService.searchByExample(Example.of(productMapper.dtoToEntityConvertor(productDto))));
    }



    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable("id") Long id) throws BaseException {
        return productMapper.entityToDtoConvertor(productService.getById(productMapper.dtoToEntityConvertor(new ProductDto(id))));
    }


    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping
    public List<ProductDto> getAll() throws BaseException {
        return productMapper.entityToDtoConvertor(productService.getAll());
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) throws BaseException {

        productService.delete(new ProductEntity(id));
        return "Product Deleted !!!";
    }


    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ProductDto update(@RequestBody @Valid ProductDto productDto) throws BaseException {
        return productMapper.entityToDtoConvertor(productService.update(productMapper.dtoToEntityConvertor(productDto)));

    }

}
