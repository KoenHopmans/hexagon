package com.novi.hexagon.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@IdClass(com.novi.hexagon.model.DemoKey.class)
@Table(name = "Demos")
public class Demo implements Serializable {

    @Id
    @Column(nullable = false)
    private String username;

    @Id
    @Column(nullable = false)
    private String demo;


    @Column
    private String artist;

    @Column
    private String feedback;

    @Column
    private String comment;

//    @OneToMany(
//            targetEntity = com.novi.hexagon.model.Comment.class,
//            mappedBy = "demo",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.EAGER)
//    private Set<Authority> comments = new HashSet<>();


    public Demo() {}
    public Demo(String username, String demo) {
        this.username = username;
        this.demo = demo;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getDemo() {
        return demo;
    }
    public void setDemo(String demo) {
        this.demo = demo;
    }
    public String getArtist() { return artist; }
    public void setArtist(String artist) { this.artist = artist; }
    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

}