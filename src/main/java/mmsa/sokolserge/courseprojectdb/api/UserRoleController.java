package mmsa.sokolserge.courseprojectdb.api;

import mmsa.sokolserge.courseprojectdb.repo.model.UserRole;
import mmsa.sokolserge.courseprojectdb.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
public class UserRoleController {
    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService){
        this.userRoleService = userRoleService;
    }

    @GetMapping(value="/userRole")
    public ResponseEntity<List<UserRole>> getUserRoles(){
        return ResponseEntity.ok(userRoleService.getUserRoles());
    }

    @PostMapping(value = "/userRole")
    public ResponseEntity<UserRole> postUserRole(@Valid @RequestBody UserRole newUserRole) {
        return ResponseEntity.ok(userRoleService.saveUserRole(newUserRole));
    }

    @GetMapping(value = "/userRole/{id}")
    public ResponseEntity<UserRole> getRole(@PathVariable Long id) {
        return ResponseEntity.ok(userRoleService.getUserRoleById(id));
    }

    @PatchMapping(value = "/userRole/{id}")
    public ResponseEntity<UserRole> updateRole(@PathVariable Long id, @Valid @RequestBody UserRole updatedUserRole) {
        return ResponseEntity.ok(userRoleService.updateUserRoleById(id, updatedUserRole));
    }

    @DeleteMapping(value = "/userRole/{id}")
    public ResponseEntity<String> deleteUserRole(@PathVariable Long id) {
        return ResponseEntity.ok(userRoleService.deleteUserRoleById(id));
    }
}
