package com.empresa.course.services;

import com.empresa.course.entities.User;
import com.empresa.course.repositories.UserRepository;
import com.empresa.course.services.exceptions.DatabaseException;
import com.empresa.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User newUser) {
       try {
           User currentUser = userRepository.getReferenceById(id);
           updateData(currentUser, newUser);
           return userRepository.save(currentUser);
       } catch (EntityNotFoundException exception) {
           throw new ResourceNotFoundException(id);
       }
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException exception) {
            throw new DatabaseException(exception.getMessage());
        }
    }

    private void updateData(User currentUser, User newUser) {
        currentUser.setName(newUser.getName());
        currentUser.setEmail(newUser.getEmail());
        currentUser.setPhone(newUser.getPhone());
    }
}
