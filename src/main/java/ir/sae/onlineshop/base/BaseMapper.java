package ir.sae.onlineshop.base;

import java.util.List;

public interface BaseMapper< T extends BaseEntity , E extends BaseDto> {

    E entityToModelConvertor(T t);

    T modelToEntityConvertor(E e);

    List<E> entityToModelConvertor(List<T> t);

    List<T> modelToEntityConvertor(List<E> e);


}
