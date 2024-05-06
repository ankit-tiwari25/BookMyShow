package dev.project.BookMyShow.controller;

import dev.project.BookMyShow.dto.requestdto.UserDTO;
import dev.project.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/createuser")
    ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO user = userService.createUser(userDTO);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @GetMapping("/findUserById/{id}")
    ResponseEntity<UserDTO> findUserById(@PathVariable("id") Integer userID){
        UserDTO userDto = userService.findUserById(userID);
        return new ResponseEntity<UserDTO>(userDto, HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    ResponseEntity deleteUserById(@PathVariable("id") Integer userId){
        userService.deleteUserById(userId);
        return ResponseEntity.ok("User deleted Successfully");
    }

    @PutMapping("/updateUser/{id}")
    ResponseEntity<UserDTO> updateUser(@PathVariable("id") Integer id, @RequestBody UserDTO userDTO){
        UserDTO responseDTO = userService.updateUserDetails(id,userDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
