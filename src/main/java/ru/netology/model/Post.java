package ru.netology.model;

public class Post {
    private long id;
    private String content;

    private static long numOfPosts;

    public Post() {
        numOfPosts += 1L;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static long getNumOfPosts() {
        return numOfPosts;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
