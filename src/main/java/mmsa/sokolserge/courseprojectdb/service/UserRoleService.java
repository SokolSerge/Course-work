package mmsa.sokolserge.courseprojectdb.service;

import mmsa.sokolserge.courseprojectdb.exception.UserRoleNotFoundException;
import mmsa.sokolserge.courseprojectdb.repo.model.UserRole;
import mmsa.sokolserge.courseprojectdb.repo.UserRoleRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {
    private final UserRoleRepo userRoleRepo;


    public UserRoleService (UserRoleRepo userRoleRepo){
        this.userRoleRepo=userRoleRepo;
    }

    public List<UserRole> getUserRoles(){
        return userRoleRepo.findAll();
    }

    public UserRole saveUserRole(UserRole newUserRole) {
        return userRoleRepo.save(newUserRole);
    }

    public UserRole getUserRoleById(Long id) {
        Optional<UserRole> userRole = userRoleRepo.findById(id);
        if (userRole.isPresent()) {
            return userRole.get();
        }
        throw new UserRoleNotFoundException();
    }

    public UserRole updateUserRoleById(Long id, UserRole updatedUserRole) {
        Optional<UserRole> userRole = userRoleRepo.findById(id);
        if (userRole.isPresent()) {;
            UserRole oldUserRole = userRole.get();
            updateRole(oldUserRole, updatedUserRole);
            return userRoleRepo.save(oldUserRole);

        }
        throw new UserRoleNotFoundException();
    }

    private void updateRole(UserRole oldUserRole, UserRole updatedUserRole) {
        oldUserRole.setRole(updatedUserRole.getRole());
    }

    public String deleteUserRoleById(Long id) {
        if (userRoleRepo.findById(id).isPresent()) {
            userRoleRepo.deleteById(id);
            return "User role was successfully deleted";
        }
        throw new UserRoleNotFoundException();
    }

}
