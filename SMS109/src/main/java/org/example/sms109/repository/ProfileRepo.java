package org.example.sms109.repository;

import org.example.sms109.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<ProfileEntity, Long> {
    ProfileEntity findByUserId(int userid);
}
