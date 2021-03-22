package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.model.Post;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository

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

    public Optional<Post> removeById(long id) {
        return Optional.ofNullable(hashMap.remove(id));

    }

}
