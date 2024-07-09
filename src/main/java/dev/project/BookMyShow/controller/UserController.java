package dev.project.BookMyShow.controller;

import dev.project.BookMyShow.dto.UserDTO;
import dev.project.BookMyShow.entity.User;
import dev.project.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    ResponseEntity addUser(@RequestBody UserDTO userDTO){
        userDTO = userService.addUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    @PutMapping("/updateUser/{id}")
    ResponseEntity updateUser(@RequestBody User user, @PathVariable("id") Integer id){
        UserDTO userDTO = userService.updateUser(user, id);
        return  ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }
    @GetMapping("/getUser/{id}")
    ResponseEntity getUserById(@PathVariable("id") Integer id){
        UserDTO userDTO = userService.getUserById(id);
        return  ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }

    @GetMapping("/getAllUsers")
    ResponseEntity getAllUser(){
        List<UserDTO> userDTOS = userService.getAllUser();
        return ResponseEntity.status(HttpStatus.OK).body(userDTOS);
    }
}
