package com.springboothibernate.hibernate.dao.impl;

import com.springboothibernate.hibernate.dao.abstraction.PostCommentDao;
import com.springboothibernate.hibernate.model.PostComment;
import org.springframework.stereotype.Repository;

@Repository
public class PostCommentDaoImpl extends AbstractDao<Long, PostComment> implements PostCommentDao {

    PostCommentDaoImpl() {
        super(PostComment.class);
    }
}
