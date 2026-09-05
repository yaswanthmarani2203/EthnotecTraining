package org.example.sms109.repository;

import org.example.sms109.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
