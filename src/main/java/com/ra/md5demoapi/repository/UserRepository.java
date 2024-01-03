package com.ra.md5demoapi.repository;

import com.ra.md5demoapi.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
    Page<User> findAllByUserNameContainingIgnoreCase(Pageable pageable, String name);
}
