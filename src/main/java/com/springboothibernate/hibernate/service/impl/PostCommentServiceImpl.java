package com.springboothibernate.hibernate.service.impl;

import com.springboothibernate.hibernate.dao.abstraction.PostCommentDao;
import com.springboothibernate.hibernate.model.PostComment;
import com.springboothibernate.hibernate.service.abstraction.PostCommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostCommentServiceImpl implements PostCommentService {

    private final PostCommentDao postCommentDao;

    public PostCommentServiceImpl(PostCommentDao postCommentDao) {
        this.postCommentDao = postCommentDao;
    }

    @Override
    public void add(PostComment postComment) {
        postCommentDao.save(postComment);
    }

    @Override
    public void update(PostComment postComment) {
        postCommentDao.update(postComment);
    }

    @Override
    public PostComment getById(Long id) {
        return postCommentDao.getById(id);
    }

    @Override
    public void delete(PostComment postComment) {
        postCommentDao.deleteEntity(postComment);
    }

    @Override
    public List<PostComment> getAll() {
        return postCommentDao.getAll();
    }

    @Override
    public void detach(PostComment postComment) {
        postCommentDao.detach(postComment);
    }

    @Override
    public PostComment getProxy(Class<PostComment> entityClass, Long id) {
        return postCommentDao.getProxy(entityClass, id);
    }

    @Override
    public List<PostComment> getAllWithJoinFetch() {
        return postCommentDao.getAllWithJoinFetch();
    }
}
