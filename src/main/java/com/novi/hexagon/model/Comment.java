package com.novi.hexagon.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(com.novi.hexagon.model.CommentKey.class)
@Table(name = "comments")
public class Comment implements Serializable {

    @Id
    @Column(nullable = false)
    private String demo;

    @Id
    @Column(nullable = false)
    private String comment;

    public Comment() {
    }

    public Comment(String demo, String comment) {
        this.demo = demo;
        this.comment = comment;
    }

    public String getDemo() {
        return demo;
    }
    public void setDemo(String demo) {
        this.demo = demo;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
