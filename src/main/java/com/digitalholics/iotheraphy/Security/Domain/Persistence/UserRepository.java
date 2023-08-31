package com.digitalholics.iotheraphy.Security.Domain.Persistence;

import com.digitalholics.iotheraphy.Security.Domain.Model.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
