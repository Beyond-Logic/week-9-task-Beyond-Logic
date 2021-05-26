package com.BeyondLogic.BlogAPI.Service;

import com.BeyondLogic.BlogAPI.Exception.UsersRegistrationException;
import com.BeyondLogic.BlogAPI.Model.Users;
import com.BeyondLogic.BlogAPI.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Optional<Users> login(String email, String password) {
        return usersRepository.login(email, password);
    }

    public Users registerUser(Users user) {
        Optional<Users> usersOptional = usersRepository.findByUserName(user.getUserName());
        if(usersOptional.isPresent()) {
            throw new UsersRegistrationException("User with username "+ user.getUserName()+" already exists");
        }

        return usersRepository.save(user);
    }

    public Users updateUser(Users user) {
        return usersRepository.save(user);
    }

    public List<Users> findAllUsers() {
        return (List<Users>) usersRepository.findAll();
    }

    public Optional<Users> findUserById(Long id) {
        return usersRepository.findById(id);
    }

    public Optional<Users> findUserUsername(String username) {
        return usersRepository.findByUserName(username);
    }

    public void deleteUserByUsername(String username) {
        usersRepository.deleteByUserName(username);
    }
    public void deleteUserById(Long id) {
        usersRepository.deleteById(id);
    }

}
