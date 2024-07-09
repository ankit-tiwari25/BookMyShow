package dev.project.BookMyShow.service;

import dev.project.BookMyShow.dto.UserDTO;
import dev.project.BookMyShow.entity.User;

import java.util.List;

public interface UserService {
    public UserDTO addUser(UserDTO user);
    public UserDTO updateUser(User user, int id);
    public UserDTO getUserById(Integer id);
    public List<UserDTO> getAllUser();
}
