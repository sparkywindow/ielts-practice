package com.practice.ieltspractice.repository;

import com.practice.ieltspractice.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findByTitle(String title);

    List<Post> findById(long id);
}
