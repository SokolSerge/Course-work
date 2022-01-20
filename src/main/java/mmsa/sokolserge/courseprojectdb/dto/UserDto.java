package mmsa.sokolserge.courseprojectdb.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@NoArgsConstructor
@Data
public class UserDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    private int phone;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String username;

    private Long userRoleId;
}