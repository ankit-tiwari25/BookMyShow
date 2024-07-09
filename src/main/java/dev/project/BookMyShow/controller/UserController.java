package dev.project.BookMyShow.controller;

import dev.project.BookMyShow.entity.User;
import dev.project.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    ResponseEntity addUser(@RequestBody User user){
        user = userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
