package net.mycompany.journalapp.repository;

import net.mycompany.journalapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

User findByUserName(String userName);
//
//    void deleteByUsername(Class<? extends Authentication> aClass);
}
