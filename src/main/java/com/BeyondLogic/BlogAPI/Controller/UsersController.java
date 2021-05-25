package com.BeyondLogic.BlogAPI.Controller;

import com.BeyondLogic.BlogAPI.Exception.ResourceNotFoundException;
import com.BeyondLogic.BlogAPI.Model.Post;
import com.BeyondLogic.BlogAPI.Model.Users;
import com.BeyondLogic.BlogAPI.Repository.PostRepository;
import com.BeyondLogic.BlogAPI.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    //GET ALL USERS
    @GetMapping
    public List<Users> getAllUsers(Users user){
        user.setComments(user.getComments());
        return (List<Users>) this.usersRepository.findAll();
    }
    //GET  BY USERNAME
    @GetMapping("/{username}")
    public Users getByUsername(@PathVariable(value = "username") String username) {
        return this.usersRepository.findByUserName(username);
    }


    //REGISTER USER
    @PostMapping("/register")
    public Users RegisterUser(@RequestBody Users user) {
        Date current_time = new Date();
        user.setRegisteredAt(current_time);
        return this.usersRepository.save(user);
    }


    @PatchMapping("/{username}")
    public ResponseEntity<Users> updateUserPartialDetail(@RequestBody Users user, @PathVariable("username") String username){
        Users existingUser = this.usersRepository.findByUserName(username);
        this.usersRepository.save(existingUser);
        return ResponseEntity.ok().build();
    }


    //UPDATE USER
    @PutMapping("/{username}")
     public Users updateUserByUsername(@RequestBody Users user, @PathVariable("username") String username ){
       Users existingUser =   this.usersRepository.findByUserName(username);
//       existingUser.setUserName(user.getUserName());
//       existingUser.setFirstName(user.getFirstName());
//       existingUser.setLastName(user.getLastName());
//       existingUser.setEmail(user.getEmail());
//       existingUser.setPassword(user.getPassword());
       Date current_time = new Date();
       existingUser.setUpdatedAt(current_time);
       return this.usersRepository.save(existingUser);
     }

    //DELETE USER BY USERNAME
    @DeleteMapping ("/{username}")
    public ResponseEntity<Users> deleteUser(@PathVariable("username") String username) {
        Users exitingUser = this.usersRepository.findByUserName(username);
        this.usersRepository.delete(exitingUser);
        return ResponseEntity.ok().build();
    }

}
