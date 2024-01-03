package com.ra.md5demoapi.service.user;

import com.ra.md5demoapi.model.entity.User;
import com.ra.md5demoapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User saveOrUpdate(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        Page<User> userPage=userRepository.findAll(pageable);
        return userPage.map(user -> new User(user.getId(), user.getUserName(), user.getEmail(), user.getPassword(), user.getOrders()));
    }

    @Override
    public Page<User> searchByName(Pageable pageable, String name) {
        Page<User> userPage=userRepository.findAllByUserNameContainingIgnoreCase(pageable, name);
        return userPage.map(user -> new User(user.getId(), user.getUserName(), user.getEmail(), user.getPassword(), user.getOrders()));
    }
}
