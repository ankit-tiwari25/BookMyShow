package dev.project.BookMyShow.serviceImpl;

import dev.project.BookMyShow.dto.UserDTO;
import dev.project.BookMyShow.entity.User;
import dev.project.BookMyShow.exception.UserNotFoundException;
import dev.project.BookMyShow.repository.UserRepo;
import dev.project.BookMyShow.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDTO addUser(UserDTO userDto) {
        User user = new User();
        user.setCreatedBy("User");
        user.setCreatedAt(LocalDateTime.now());
        user.setUserName(userDto.getUserName());
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setPassword(generatePassword(user.getName(), user.getAge()));
        user = userRepo.save(user);
        return userDto;
    }


    @Override
    public UserDTO updateUser(User user, int id) {
        Optional<User> userDB = userRepo.findById(id);
        User dbUSer = userDB.get();
        if(!userDB.isPresent()){
            throw  new UserNotFoundException("User not found!");
        }else{

            dbUSer.setUserName(user.getUserName());
            dbUSer.setPassword(user.getPassword());
            dbUSer.setName(user.getName());
            dbUSer.setAge(user.getAge());
            dbUSer.setUpdateBy(user.getName());
            dbUSer.setUpdatedAt(LocalDateTime.now());
            userRepo.save(dbUSer);
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setName(dbUSer.getName());
        userDTO.setUserName(dbUSer.getUserName());
        userDTO.setAge(dbUSer.getAge());
        return userDTO;
    }

    @Override
    public UserDTO getUserById(Integer id) {
        Optional<User> userDB = userRepo.findById(id);
        User dbUser = userDB.get();
        if(!userDB.isPresent()){
            throw  new UserNotFoundException("User not found!");
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(dbUser.getAge());
        userDTO.setName(dbUser.getName());
        userDTO.setUserName(dbUser.getUserName());

        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUser() {
        List<User> users = userRepo.findAll();
        List<UserDTO> userDTOS = users.stream().map((user)->modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
        return userDTOS;
    }

    private String generatePassword(String name, Integer age){
        String password = name + age;
        return password;
    }
}
