package ru.netology.repository;

import ru.netology.model.Post;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class PostRepository {

    private final ConcurrentHashMap<Long, Post> hashMap = new ConcurrentHashMap<>();

    public ConcurrentHashMap<Long, Post> all() {
        return hashMap;
    }

    public Optional<Post> getById(long id) {
        return Optional.ofNullable(hashMap.get(id));
    }

    public Post save(Post post) {
        hashMap.put(post.getId(), post);
        return post;
    }

    public boolean removeById(long id) {
        boolean isRemoved = false;

        if (hashMap.remove(id) != null) {
            isRemoved = true;
        }

        return isRemoved;
    }

}
