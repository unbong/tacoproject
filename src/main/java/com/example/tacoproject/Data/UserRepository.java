package com.example.tacoproject.Data;


import com.example.tacoproject.Secure.UserForm;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserForm, Long> {
    UserForm findByUsername(String username);
}
