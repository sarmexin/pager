package com.sarmexin.postman.services.impl;

import com.sarmexin.postman.entity.User;
import com.sarmexin.postman.repository.UserRepository;
import com.sarmexin.postman.services.UserServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Sergey Gavrilov
 */
@Slf4j
@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class UserServicesImpl implements UserServices {

    private final UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findOne(long id) {
        Optional<User> foundUser = repository.findById(id);
        return foundUser.orElseGet(null);
    }

    @Transactional
    public void save(User user) {
        repository.save(user);
    }

    @Transactional
    public void update(long id, User updateUser) {
        updateUser.setId(id);
        repository.save(updateUser);
    }

    @Transactional
    public void delete(long id) {
        repository.deleteById(id);
    }

}