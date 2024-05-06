package dev.project.BookMyShow.service;

import dev.project.BookMyShow.dto.requestdto.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO findUserById(int userId);

    void deleteUserById(int id);

    UserDTO updateUserDetails(Integer userId, UserDTO userDTO);

}
