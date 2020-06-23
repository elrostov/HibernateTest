package com.springboothibernate.hibernate.service.impl;

import com.springboothibernate.hibernate.dao.abstraction.PostDao;
import com.springboothibernate.hibernate.model.Post;
import com.springboothibernate.hibernate.service.abstraction.PostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final PostDao postDao;

    public PostServiceImpl(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public void add(Post post) {
        postDao.save(post);
    }

    @Override
    public void update(Post post) {
        postDao.update(post);
    }

    @Override
    public Post getById(Long id) {
        return postDao.getById(id);
    }

    @Override
    public void delete(Post post) {
        postDao.deleteEntity(post);
    }

    @Override
    public List<Post> getAll() {
        return postDao.getAll();
    }

    @Override
    public void detach(Post post) {
        postDao.detach(post);
    }

    @Override
    public Post getProxy(Class<Post> entityClass, Long id) {
        return postDao.getProxy(entityClass, id);
    }

    @Override
    public void getAllWithJoinFetch() {
        postDao.getAllWithJoinFetch();
    }

    @Override
    public void getAllWithLeftJoinFetch() {

    }

    @Override
    public void getAllWithEntityGraph() {

    }
}
