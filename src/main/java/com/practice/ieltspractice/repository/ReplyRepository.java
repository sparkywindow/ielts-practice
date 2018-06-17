package com.practice.ieltspractice.repository;

import com.practice.ieltspractice.model.Post;
import com.practice.ieltspractice.model.Reply;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReplyRepository extends CrudRepository<Reply, Long> {

    List<Reply> findAllByPostId(long PostId);
}
