package com.empresa.course.services;

import com.empresa.course.entities.User;
import com.empresa.course.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> optional = userRepository.findById(id);
        return optional.get();
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User newUser) {
        User currentUser = userRepository.getReferenceById(id);
        updateData(currentUser, newUser);
        return userRepository.save(currentUser);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private void updateData(User currentUser, User newUser) {
        currentUser.setName(newUser.getName());
        currentUser.setEmail(newUser.getEmail());
        currentUser.setPhone(newUser.getPhone());
    }
}
