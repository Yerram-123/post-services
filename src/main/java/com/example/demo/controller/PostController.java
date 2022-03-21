package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class PostController {
    @Autowired
    private PostService postService;

    // Save operation
    @PostMapping("/posts")

    public ResponseEntity<Post> savePost( @RequestBody Post post)
    {
        return new ResponseEntity<Post>(postService.createPost(post),HttpStatus.CREATED);

    }

    // Read operation
    @GetMapping("/posts")

    public ResponseEntity<List<Post>> getPosts()
    {
      //  return postService.getPostDetails();
        return new ResponseEntity<List<Post>>(postService.getPostDetails(), HttpStatus.OK);
    }

    // Update operation
    @PutMapping("/posts/{postId}")

    public ResponseEntity<Post> updatePost(@RequestBody Post post,
                     @PathVariable("postId") String postId)
    {

        return  new ResponseEntity<Post>(postService.updatePost(
            post, postId),HttpStatus.OK);
    }

    // Delete operation
    @DeleteMapping("/posts/{postId}")

    public ResponseEntity<Post> deletePost(@PathVariable("postId")
                                               String postId)
    {
        //postService.deletePostById(
              //  postId);
        //return "Deleted Successfully";
        return  new ResponseEntity<Post>(postService.deletePostById(postId),HttpStatus.OK);
    }

}
