package com.ra.md5demoapi.service.user;

import com.ra.md5demoapi.model.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void delete(Long id);
    User saveOrUpdate(User user);
    User findById(Long id);
}
