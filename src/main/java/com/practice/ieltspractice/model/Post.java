package com.practice.ieltspractice.model;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String youtubeUrl;

    //default constructor for JPA
    protected Post() {}

    public Post(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "sparkyness";
    }

    public String getTitle() { return this.title; }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public long getId() { return this.id; }


}
