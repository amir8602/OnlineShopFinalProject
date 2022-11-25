package ir.sae.onlineshop.base;


import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public abstract class BaseServiceImpl < T extends JpaRepository< V , E >, V extends BaseEntity , E> {

    protected final T repository;

    public BaseServiceImpl(T repository) {
        this.repository = repository;
    }
    @Transactional
    public V save(V v){
        return repository.save(v);
    }
    public Optional<V> getById(E e){
        return repository.findById(e);
    }
    public List<V> getAll(){
        return repository.findAll();
    }
    @Transactional
    public V update(V v){
        return repository.save(v);
    }
    public void delete(E e){
        repository.deleteById(e);
    }
    public List<V> searchByExample(Example<V> vExample){
        return repository.findAll(vExample);
    }



}
