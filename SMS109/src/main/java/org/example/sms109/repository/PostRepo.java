package org.example.sms109.repository;

import org.example.sms109.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByUserId(int userId);
}
