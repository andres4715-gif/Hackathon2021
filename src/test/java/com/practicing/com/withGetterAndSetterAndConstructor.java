package com.practicing.com;


public class withGetterAndSetterAndConstructor {

    private Integer id;
    private String body;
    private Integer postId;

    public withGetterAndSetterAndConstructor(Integer id, String body, Integer postId) {
        this.id = id;
        this.body = body;
        this.postId = postId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
}
