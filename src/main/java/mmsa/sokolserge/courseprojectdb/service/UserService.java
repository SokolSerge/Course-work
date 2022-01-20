package mmsa.sokolserge.courseprojectdb.service;

import mmsa.sokolserge.courseprojectdb.dto.UserDto;
import mmsa.sokolserge.courseprojectdb.exception.UserNotFoundException;
import mmsa.sokolserge.courseprojectdb.exception.UserRoleNotFoundException;
import mmsa.sokolserge.courseprojectdb.repo.model.User;
import mmsa.sokolserge.courseprojectdb.repo.UserRepo;
import mmsa.sokolserge.courseprojectdb.repo.UserRoleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepo userRepo;
    private final UserRoleRepo userRoleRepo;

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User saveUser(UserDto newUser) {
        User user=User.builder()
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .phone(newUser.getPhone())
                .email(newUser.getEmail())
                .password(newUser.getPassword())
                .username(newUser.getUsername())
                .userRole(userRoleRepo.findById(newUser.getUserRoleId()).orElseThrow(UserRoleNotFoundException::new))
                .build();
        return userRepo.save(user);
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UserNotFoundException();
    }

    public User updateUserById(Long id, UserDto updatedUser) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {;
            User oldUser = user.get();
            updatedUser(oldUser, updatedUser);
            return userRepo.save(oldUser);

        }
        throw new UserNotFoundException();
    }

    private void updatedUser(User oldUser, UserDto updatedUser) {
        oldUser.setFirstName(updatedUser.getFirstName());
        oldUser.setLastName(updatedUser.getLastName());
        oldUser.setPhone(updatedUser.getPhone());
        oldUser.setEmail(updatedUser.getEmail());
        oldUser.setPassword(updatedUser.getPassword());
        oldUser.setUsername(updatedUser.getUsername());
        oldUser.setUserRole(userRoleRepo.findById(updatedUser.getUserRoleId()).orElseThrow(UserRoleNotFoundException::new));
    }

    public String deleteUserById(Long id) {
        if (userRepo.findById(id).isPresent()) {
            userRepo.deleteById(id);
            return "User was successfully deleted";
        }
        throw new UserNotFoundException();
    }
}
