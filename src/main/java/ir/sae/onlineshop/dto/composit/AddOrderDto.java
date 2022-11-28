package ir.sae.onlineshop.dto.composit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddOrderDto  {

    @Range(min = 0)
    private Long productId;


    @Range(min = 0)
    private Long count;

}
