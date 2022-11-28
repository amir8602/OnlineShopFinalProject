package ir.sae.onlineshop.base;

import ir.sae.onlineshop.dto.IsNotNull2;
import ir.sae.onlineshop.exceptions.BaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
public abstract class BaseRestController<D extends BaseDto,
        E extends BaseEntity,
        M extends BaseMapper<E, D>,
        S extends BaseService<E, ID>,
        ID extends Serializable> {

    protected final S service;
    protected final M mapper;

    @PostMapping
    public ResponseEntity<D> add(@Valid @RequestBody D d) throws BaseException {
        return ResponseEntity.ok(mapper.entityToDtoConvertor(service.saveOrUpdate(mapper.dtoToEntityConvertor(d))));
    }

    @PutMapping
    public ResponseEntity<D> update(@Valid @RequestBody D d) throws BaseException {
        return ResponseEntity.ok(mapper.entityToDtoConvertor(service.saveOrUpdate(mapper.dtoToEntityConvertor(d))));
    }


    @PostMapping("/find")
    public ResponseEntity<List<D>> findAll(@RequestBody @Validated(IsNotNull2.class) D d) throws BaseException {
         return ResponseEntity.ok(mapper.entityToDtoConvertor(service.findAll(mapper.dtoToEntityConvertor(d))));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable ID id) throws BaseException {
        service.deleteById(id);
    }

}