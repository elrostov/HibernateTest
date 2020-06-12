package com.springboothibernate.hibernate.service.abstraction;

import com.springboothibernate.hibernate.model.Post;
import com.springboothibernate.hibernate.model.PostComment;
import com.springboothibernate.hibernate.model.compositeKey.Customer;

import java.util.List;

public interface PostCommentService {
    void add(PostComment postComment);
    void update(PostComment postComment);
    PostComment getById(Long id);
    void delete(PostComment postComment);
    List<PostComment> getAll();
    void detach(PostComment postComment);
    PostComment getProxy(Class<PostComment> entityClass, Long id);
    List<PostComment> getAllWithJoinFetch();
}
