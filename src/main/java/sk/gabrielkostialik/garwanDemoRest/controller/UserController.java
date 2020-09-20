package sk.gabrielkostialik.garwanDemoRest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import sk.gabrielkostialik.garwanDemoRest.excpetion.UserAlreadyExist;
import sk.gabrielkostialik.garwanDemoRest.model.User;
import sk.gabrielkostialik.garwanDemoRest.model.dto.UserDto;
import sk.gabrielkostialik.garwanDemoRest.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/Userlogout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@Valid @RequestBody UserDto userDto) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = userDto.getPassword();
        String encodedPassword = passwordEncoder.encode(password);

        User user = new User();
        user.setPassword(encodedPassword);
        user.setUsername(userDto.getUsername());
        user.setRole("ROLE_USER");
        user.setEnabled(true);

        if (userRepository.getUserByUsername(user.getUsername()) == null) {
            userRepository.save(user);
        } else {
            throw new UserAlreadyExist(user.getUsername());
        }
    }

    @GetMapping("/user")
    public List<User> addUser() {
        return userRepository.findAll();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
