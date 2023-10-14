package com.sarmexin.postman.services.impl;

import com.sarmexin.postman.domain.UserData;
import com.sarmexin.postman.repo.UserRepository;
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

    public List<UserData> findAll() {
        return repository.findAll();
    }

    public UserData findOne(long id) {
        Optional<UserData> foundUser = repository.findById(id);
        return foundUser.orElseGet(null);
    }

    @Transactional
    public void save(UserData user) {
        repository.save(user);
    }

    @Transactional
    public void update(long id, UserData updateUser) {
        updateUser.setId(id);
        repository.save(updateUser);
    }

    @Transactional
    public void delete(long id) {
        repository.deleteById(id);
    }

}
