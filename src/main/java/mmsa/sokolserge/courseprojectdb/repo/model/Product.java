package mmsa.sokolserge.courseprojectdb.repo.model;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "products")
@Getter
public class Product
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Setter
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_group_id")
    private ProductGroup productGroupId;

    public void setProductName(String productName) {
    }
}
