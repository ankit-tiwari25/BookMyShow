package dev.project.BookMyShow.service;

import dev.project.BookMyShow.entity.User;

public interface UserService {
    public User addUser(User user);
    public User updateUser(User user);
    public User getUserById(Integer id);
    public User getAllUser();
}
