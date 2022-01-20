package mmsa.sokolserge.courseprojectdb.repo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "product_price")
@Getter
public class ProductPrice
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private Product product;

    @Setter
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_size_id")
    private ProductSize productSize;

    @Setter
    @Column(name = "price")
    private double price;


}
