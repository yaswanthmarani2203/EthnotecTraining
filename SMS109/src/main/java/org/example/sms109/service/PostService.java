package org.example.sms109.service;

import org.example.sms109.entity.PostEntity;
import org.example.sms109.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepo repo;

    public PostEntity savePost(PostEntity post) {
        return repo.save(post);
    }
    public List<PostEntity> getAllPost()
    {
        return repo.findAll();
    }
    public List<PostEntity> getUserPosts(int userId)
    {
        return repo.findByUserId(userId);
    }
    public String deletePost(PostEntity post)
    {
        repo.delete(post);
        return"Post deleted successfully";
    }
    public String deletePost01(PostEntity post)
    {
        repo.deleteById(post.getId());
        return"Post deleted successfully";
    }
    public String deletePost02(Long postId)
    {
        repo.deleteById(postId);
        return"Post deleted successfully";
    }
    public PostEntity updatePost(PostEntity post)
    {
        PostEntity res = repo.findById(post.getId()).orElse(null);
        if(res != null)
        {
            res.setTitle(post.getTitle());
            res.setDescription(post.getDescription());
            res.setPostImage(post.getPostImage());
            return repo.save(res);
        }
        return null;
    }
    public String updatePostByPatch(String title, String description, Long Id)
    {
        PostEntity res = repo.findById(Id).orElse(null);
        if(res != null)
        {
            res.setTitle(title);
            res.setDescription(description);
            repo.save(res);
        }
        return "Post Updated successfully";
    }
}
