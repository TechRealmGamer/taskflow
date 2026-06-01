package com.prince.taskflow.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // JpaRepository gives you save(), findById(), findAll(), deleteById() for FREE
}
