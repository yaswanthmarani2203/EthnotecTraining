package org.example.sms109.controller;

import org.example.sms109.entity.ProfileEntity;
import org.example.sms109.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {
    @Autowired
    ProfileService ser;

    @PostMapping("/addProfile")
    public ProfileEntity addProfile(@RequestBody ProfileEntity en) {
        return ser.saveProfile(en);
    }

    @GetMapping("/getProfile/{userId}")
    public ProfileEntity getProfile(@PathVariable int userId) {
        return ser.getProfile(userId);
    }
}


