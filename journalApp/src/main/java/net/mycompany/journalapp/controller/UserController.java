package net.mycompany.journalapp.controller;

import net.mycompany.journalapp.entity.User;
import net.mycompany.journalapp.repository.UserRepository;
import net.mycompany.journalapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAll();
    }

    //Y DEKHNA HAI YTUBE ME
    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
        //LEKN YHA J.E. KI LIST TO SET KRAEE NHI VO TO NULL AAEGI
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String userName) {
        User userInDB = userService.findByUserName(userName);
        if (user.getUserName() != null) {
            userInDB.setUserName(user.getUserName());
            userInDB.setPassword(user.getPassword());
            userService.saveUser(userInDB);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Autowired
    private UserRepository userRepository;

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestBody User user, @PathVariable String userName) {
      //  Authentication authentication=new SecurityContextHolder().getContext().getAuthentication();
        //userRepository.deleteByUsername(authentication.getClass());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}