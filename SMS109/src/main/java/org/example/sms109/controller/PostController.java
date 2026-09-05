package org.example.sms109.controller;

import jakarta.persistence.Id;
import org.example.sms109.entity.PostEntity;
import org.example.sms109.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService ser;
    private PostEntity post;


    @PostMapping("/addPost")
    public PostEntity savepost(@RequestBody PostEntity post) {
        return ser.savePost(post);
    }

    @GetMapping("/getAllPost")
    public List<PostEntity> getAllPost()
    {
        return ser.getAllPost();
    }

    @GetMapping("/getUserPost/{userId}")
    public List<PostEntity> getUserPost(@PathVariable int userId)
    {
        return ser.getUserPosts(userId);
    }

    @DeleteMapping("/deletePost")
    public String deletePost(@RequestBody PostEntity post)
    {

        return ser.deletePost(post);
    }

    @DeleteMapping("/deletePost01")
    public String deletePost01(@RequestBody PostEntity post)
    {
        return ser.deletePost01(post);
    }

    @DeleteMapping("/deletePost02/{id}")
    public String deletePost02(@PathVariable int id)
    {
        return ser.deletePost02((long) id);
    }
    @GetMapping("/updatePost")
    public PostEntity updatePost(@RequestBody PostEntity post) {
        return ser.updatePost(post);
    }
    @PatchMapping("/updatePostByPatch")
    public String updatePostByPatch(@RequestParam String title,
                                    @RequestParam String description,
                                    @RequestParam Long Id) {
        return ser.updatePostByPatch(title,description, Id);

    }
}
