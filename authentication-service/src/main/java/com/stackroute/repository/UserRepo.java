package com.stackroute.repository;
import com.stackroute.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User,String> {
    User findByEmailAndPassword(String email, String password);

}
