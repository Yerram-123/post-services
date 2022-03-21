package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class PostService {
    @Autowired
    PostRepo postRepo;

    public List<Post> getPostDetails(){
        return postRepo.findAll();
    }
    public Post createPost(Post post) {

       return postRepo.save(post);
    }
    // Update operation

    public Post updatePost(Post post,
                           String postedBy)
    {



        Post updatedUser   = postRepo.findById(postedBy).get();
        updatedUser.setPost(post.getPost());
        updatedUser.setPostedBy(post.getPostedBy());
        updatedUser.setCreatedAt(LocalDate.now());
        updatedUser.setUpdatedAt(LocalDate.now());



        return postRepo.save(updatedUser);
    }

    // Delete operation

    public Post deletePostById(String postId)
    {
        Post post = postRepo.findById(postId).get();
        post.setActive(false);
        return postRepo.save(post);
    }
}
