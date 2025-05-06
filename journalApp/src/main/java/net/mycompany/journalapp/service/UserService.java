package net.mycompany.journalapp.service;

import net.mycompany.journalapp.entity.User;
import net.mycompany.journalapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
       return userRepository.findAll();
    }

    public void saveUser(User user) {
       userRepository.save(user);
    }

//    private static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
//
//    public void saveNewUser(User user) {
//   user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//    }

   public User findByUserName(String userName){
       return userRepository.findByUserName(userName);
    }
}
