package org.example.sms109.service;

import org.example.sms109.entity.ProfileEntity;
import org.example.sms109.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {
    @Autowired
    ProfileRepo repo;

    public ProfileEntity saveProfile(ProfileEntity pro)
    {
        return repo.save(pro);
    }
    public ProfileEntity getProfile(int userId)
    {
        return repo.findByUserId(userId);
    }
}
