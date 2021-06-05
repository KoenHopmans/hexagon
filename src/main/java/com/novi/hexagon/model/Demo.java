package com.novi.hexagon.model;

import javax.persistence.*;
import java.io.Serializable;

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

}