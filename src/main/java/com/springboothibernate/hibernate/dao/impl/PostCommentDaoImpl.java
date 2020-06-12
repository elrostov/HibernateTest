package com.springboothibernate.hibernate.dao.impl;

import com.springboothibernate.hibernate.dao.abstraction.PostCommentDao;
import com.springboothibernate.hibernate.model.PostComment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostCommentDaoImpl extends AbstractDao<Long, PostComment> implements PostCommentDao {

    PostCommentDaoImpl() {
        super(PostComment.class);
    }

    @Override
    public List<PostComment> getAllWithJoinFetch() {
        return em.createQuery(
                "SELECT pc FROM PostComment pc JOIN FETCH  pc.post ",
                PostComment.class)
                .getResultList();
    }
}
