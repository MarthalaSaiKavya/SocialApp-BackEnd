package com.example.socialapp.repository;

import com.example.socialapp.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByAuthor(String author);
}

