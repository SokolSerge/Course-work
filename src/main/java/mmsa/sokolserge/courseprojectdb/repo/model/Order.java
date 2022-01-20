package mmsa.sokolserge.courseprojectdb.repo.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "orders")
@Getter
public class Order
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User userId;

    @Setter
    @NotNull
    @Column(name = "table_id")
    private Long tableId;

    @Setter
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_price_id")
    private ProductPrice productPriceId;

    @Setter
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_status")
    private Status statusId;

}
