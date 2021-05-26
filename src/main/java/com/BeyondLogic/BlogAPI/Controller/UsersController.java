package com.BeyondLogic.BlogAPI.Controller;
import com.BeyondLogic.BlogAPI.Model.Users;
import com.BeyondLogic.BlogAPI.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UsersController {

    @Autowired
    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    //GET ALL USERS
    @GetMapping
    public List<Users> getAllUsers() {
        return userService.findAllUsers();
    }

    //GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserByUsername(@PathVariable Long id) {
        return userService.findUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //GET USER BY USERNAME
    @GetMapping("/{username}")
    public ResponseEntity<Users> getUserByUsername(@PathVariable String username) {
        return userService.findUserUsername(username)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    //REGISTER USER


    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Users RegisterUser(@RequestBody @Valid Users user) {
        Date current_time = new Date();
        user.setRegisteredAt(current_time);
        return userService.registerUser(user);
    }

    //UPDATE USER
    @PutMapping("/{username}")
     public ResponseEntity<Users> updateUser(@PathVariable("username") String username, @RequestBody @Valid Users user ){
        return userService.findUserUsername(username)
                .map(userObj -> {
                            Date current_time = new Date();
            userObj.setUpdatedAt(current_time);
            userObj.setUserName(username);
            return ResponseEntity.ok(userService.updateUser(userObj));
        }).orElseGet(() -> ResponseEntity.notFound().build());
     }

    //DELETE USER BY USERNAME
    @DeleteMapping ("/{username}")
    public ResponseEntity<Users> deleteUser(@PathVariable("username") String username) {
      return userService.findUserUsername(username)
              .map(users -> {
                  userService.deleteUserByUsername(username);
                  return ResponseEntity.ok(users);
              })
              .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
