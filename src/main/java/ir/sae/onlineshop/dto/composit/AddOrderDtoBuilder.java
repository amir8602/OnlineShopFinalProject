package ir.sae.onlineshop.dto.composit;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AddOrderDtoBuilder {

    private Long productId;
    private Long count;


    public AddOrderDtoBuilder setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public AddOrderDtoBuilder setCount(Long count) {
        this.count = count;
        return this;
    }

    public AddOrderDto build(){
        return new AddOrderDto(productId,count);
    }

}
