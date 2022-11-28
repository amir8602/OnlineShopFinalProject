package ir.sae.onlineshop.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDto{

    private Integer version;

    private Date createDate;

    private Date updateDate;


}
