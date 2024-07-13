package com.example.RegisterdanLogin.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import com.example.RegisterdanLogin.entity.User;
import com.example.RegisterdanLogin.model.RegisterUserRequest;
import com.example.RegisterdanLogin.model.UserResponse;
import com.example.RegisterdanLogin.repository.UserRepository;
import com.example.RegisterdanLogin.security.BCrypt;

import java.util.Objects;
import java.util.Set;

@Service
@Slf4j
public class UserService {
     @Autowired
    private UserRepository userRepository;
     @Autowired
     private Validator validator;
    @Transactional
     public void register(RegisterUserRequest request){
        Set<ConstraintViolation<RegisterUserRequest>> constraintViolations = validator.validate(request);
        if (constraintViolations.size() != 0){
            throw new ConstraintViolationException(constraintViolations);

        }
    if (userRepository.existsById(request.getUsername())){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Username Sudah digunakan");
    }
        User user = new User();
    user.setUsername(request.getUsername());
    user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
    user.setSurel(request.getSurel());

    userRepository.save(user);
    }
    public UserResponse get(User user) {
        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getSurel())
                .build();
    }


}
