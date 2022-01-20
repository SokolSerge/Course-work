package mmsa.sokolserge.courseprojectdb.api;

import mmsa.sokolserge.courseprojectdb.dto.UserDto;
import mmsa.sokolserge.courseprojectdb.repo.model.User;
import mmsa.sokolserge.courseprojectdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping(value="/user")
    public ResponseEntity<List<User>> getUser(){
        return ResponseEntity.ok(userService.getUsers());
    }
    @PostMapping(value = "/user")
    public ResponseEntity<User> postUser(@RequestBody UserDto newUser) {
        return ResponseEntity.ok(userService.saveUser(newUser));
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PatchMapping(value = "/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody UserDto updatedUser) {
        return ResponseEntity.ok(userService.updateUserById(id, updatedUser));
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.deleteUserById(id));
    }
}
