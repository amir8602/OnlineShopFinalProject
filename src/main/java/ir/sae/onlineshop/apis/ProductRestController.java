package ir.sae.onlineshop.apis;

import ir.sae.onlineshop.base.BaseRestController;
import ir.sae.onlineshop.dto.IsNotNull2;
import ir.sae.onlineshop.dto.ProductDto;
import ir.sae.onlineshop.entities.ProductEntity;
import ir.sae.onlineshop.exceptions.BaseException;
import ir.sae.onlineshop.image.FileDB;
import ir.sae.onlineshop.image.FileStorageService;
import ir.sae.onlineshop.mappers.ProductMapper;
import ir.sae.onlineshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Override
    @PostMapping
    public ResponseEntity<ProductDto> add(@RequestBody @Validated(IsNotNull2.class) ProductDto productDto) throws BaseException {
        ProductEntity productEntity = productMapper.dtoToEntityConvertor(productDto);
        FileDB image = imageService.getFile(productDto.getFileId());
        productEntity.setFile(image);
        ProductEntity productEntity1 = productService.saveOrUpdate(productEntity);
        ProductDto productDto1 = productMapper.entityToDtoConvertor(productEntity1);
        productDto1.setFileId(productDto.getFileId());
        return ResponseEntity.ok(productDto1);
    }

}
