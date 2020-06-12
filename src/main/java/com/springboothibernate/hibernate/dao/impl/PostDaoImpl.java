package com.springboothibernate.hibernate.dao.impl;

import com.springboothibernate.hibernate.dao.abstraction.PostDao;
import com.springboothibernate.hibernate.model.Post;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDaoImpl extends AbstractDao<Long, Post> implements PostDao {

    PostDaoImpl() {
        super(Post.class);
    }

    @Override
    public List<Post> getAllWithJoinFetch() {
        return getAll();
    }
}
