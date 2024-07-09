package dev.project.BookMyShow.serviceImpl;

import dev.project.BookMyShow.entity.User;
import dev.project.BookMyShow.repository.UserRepo;
import dev.project.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public User addUser(User user) {
        user.setCreatedBy("User");
        user.setCreatedAt(LocalDateTime.now());
        user = userRepo.save(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public User getAllUser() {
        return null;
    }
}
