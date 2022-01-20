package mmsa.sokolserge.courseprojectdb.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;

@NoArgsConstructor
@Data
public class ProductPriceDto {
    @NotNull
    private Long productId;

    @NotNull
    private Long productSizeId;

    private double price;
}
