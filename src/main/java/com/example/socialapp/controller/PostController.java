package com.example.socialapp.controller;

import com.example.socialapp.model.Post;
import com.example.socialapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.savePost(post));
    }

    @GetMapping("/home")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @GetMapping("/tweets/{author}")
    public ResponseEntity<List<Post>> getTweetsByAuthor(@PathVariable String author) {
        List<Post> tweetsByAuthor = postService.getTweetsByAuthor(author);
        return ResponseEntity.ok(tweetsByAuthor);
    }
}
