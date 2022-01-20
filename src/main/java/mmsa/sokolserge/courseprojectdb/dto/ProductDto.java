package mmsa.sokolserge.courseprojectdb.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ProductDto {
    @NotNull
    private String productName;

    @NotNull
    private Long productGroupId;
}