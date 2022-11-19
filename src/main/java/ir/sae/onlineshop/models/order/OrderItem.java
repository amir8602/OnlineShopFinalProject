package ir.sae.onlineshop.models.order;

import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class OrderItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @NotNull
    @Range(min = 0)
    @Column(name ="number")
    private int quantity;

    @NotNull
    @Column(name ="price")
    private double totalPrice;
}
