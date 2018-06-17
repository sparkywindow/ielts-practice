package com.practice.ieltspractice.model;

import javax.persistence.*;

@Entity
@Table(name = "reply")
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long postId;

    private String youtubeUrl;

    //default constructor for JPA
    protected Reply() {}

    public Reply(long postId, String youtubeUrl) {

        this.postId = postId;
        this.youtubeUrl = youtubeUrl;
    }

    @Override
    public String toString() {
        return "sparkyness";
    }

    public String getYoutubeUrl() {return youtubeUrl; }


}
