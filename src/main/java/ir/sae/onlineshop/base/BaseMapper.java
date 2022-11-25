package ir.sae.onlineshop.base;

import java.util.List;

public interface BaseMapper< T extends BaseEntity , E extends BaseDto> {

    E entityToDtoConvertor(T t);

    T dtoToEntityConvertor(E e);

    List<E> entityToDtoConvertor(List<T> t);

    List<T> dtoToEntityConvertor(List<E> e);


}
