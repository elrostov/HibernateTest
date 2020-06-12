package com.springboothibernate.hibernate.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity(name = "PostComment")
@Table(name = "post_comment")
public class PostComment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Post post;

    private String review;

    public PostComment(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "PostComment{" +
                "id=" + id +
                ", post=" + post +
                ", review='" + review + '\'' +
                '}';
    }
}
