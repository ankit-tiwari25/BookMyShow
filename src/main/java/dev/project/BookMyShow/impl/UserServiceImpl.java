package dev.project.BookMyShow.impl;

import dev.project.BookMyShow.dto.requestdto.UserDTO;
import dev.project.BookMyShow.entity.User;
import dev.project.BookMyShow.exception.UserNotFoundException;
import dev.project.BookMyShow.repository.UserRepo;
import dev.project.BookMyShow.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user;
        user = modelMapper.map(userDTO, User.class);
        userRepo.save(user);
        return userDTO;
    }

    @Override
    public UserDTO findUserById(int userId) {
        User user = userRepo.findById(userId).orElseThrow( ()-> new UserNotFoundException("User","id",userId));

        UserDTO userDto = modelMapper.map(user, UserDTO.class);

        return userDto;
    }

    @Override
    public void deleteUserById(int id) {

        User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User","id",id));
        userRepo.delete(user);
    }

    @Override
    public UserDTO updateUserDetails(Integer id, UserDTO userDTO) {
        User userDB = userRepo.findById(id).orElseThrow(()-> new UserNotFoundException("User","id",id));
        userDB.setAge(userDTO.getAge());
        userDB.setName(userDTO.getName());
        userDB.setUpdateAt(LocalDateTime.now());

        userDB = userRepo.save(userDB);

        return modelMapper.map(userDB, UserDTO.class);
    }
}
