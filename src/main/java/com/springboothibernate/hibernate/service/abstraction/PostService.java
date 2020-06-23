package com.springboothibernate.hibernate.service.abstraction;

import com.springboothibernate.hibernate.model.Post;
import com.springboothibernate.hibernate.model.compositeKey.Customer;

import java.util.List;

public interface PostService {
    void add(Post post);
    void update(Post post);
    Post getById(Long id);
    void delete(Post post);
    List<Post> getAll();
    void detach(Post post);
    Post getProxy(Class<Post> entityClass, Long id);
    void getAllWithJoinFetch();
    void getAllWithLeftJoinFetch();
    void getAllWithEntityGraph();
}
