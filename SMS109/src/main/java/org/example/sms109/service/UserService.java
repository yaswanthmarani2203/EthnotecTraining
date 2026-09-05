package org.example.sms109.service;

import org.example.sms109.entity.UserEntity;
import org.example.sms109.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo repo;

    public String userRegister(UserEntity user) {
        UserEntity res = repo.findByEmail  (user.getEmail());
        if(res == null){
            res = repo.save(user);
            return "User Registered Successfully";
        }
        return "User Already exists";
    }
    public UserEntity login(UserEntity user) {
        UserEntity res = repo.findByEmail(user.getEmail());

        if(res != null && user.getPassword().equals(res.getPassword())){
            return res;
        }
        return null;
    }
}
