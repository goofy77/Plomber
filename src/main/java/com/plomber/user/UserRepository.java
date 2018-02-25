package com.plomber.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

interface UserRepository extends Repository<User, Integer> {
    User save(User user);
    User findOne(Integer id);
    void delete(Integer id);
    Page<User> findAll(Pageable pageable);
    boolean existsByEmail(String email);
}
