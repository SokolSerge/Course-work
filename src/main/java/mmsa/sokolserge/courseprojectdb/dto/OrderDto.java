package mmsa.sokolserge.courseprojectdb.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class OrderDto {
    @NotNull
    private Long userId;

    @NotNull
    private Long tableId;

    @NotNull
    private Long productPriceId;

    @NotNull
    private Long statusId;

}
