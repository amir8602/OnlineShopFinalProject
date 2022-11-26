package ir.sae.onlineshop.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


public class BaseController<D extends BaseDto<T>, T, E extends BaseEntity,
        M extends BaseMapper<E, D>,
        S extends BaseServiceImpl<? extends JpaRepository<E, T>, E, T>> {


    private  S service;
    private M mapper;


    @Transactional
    @PostMapping
    public D save(@Valid @RequestBody D d) {
        E e = mapper.dtoToEntityConvertor(d);
        BaseEntity save = service.save(e);
        return mapper.entityToDtoConvertor((E) save);


    }

    @Transactional
    @PutMapping
    public D update(@Valid @RequestBody D d) {
        E e = mapper.dtoToEntityConvertor(d);
        BaseEntity update = service.update(e);
        return mapper.entityToDtoConvertor((E) update);

    }

    @GetMapping("/{id}")
    public Optional<E> findById(@PathVariable("id") T id) {
        Optional<E> byId = service.getById(id);
        return byId;

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable T id) {
        service.delete(id);

    }

    @GetMapping()
    public List<D> findAll() {
        List<E> all = service.getAll();
        return mapper.entityToDtoConvertor(all);

    }
}