package ru.netology.service;

import org.springframework.stereotype.Service;
import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;
import ru.netology.repository.PostRepository;

import java.util.concurrent.ConcurrentHashMap;

@Service

public class PostService {
    private final PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public ConcurrentHashMap<Long, Post> all() {
        return repository.all();
    }

    public Post getById(long id) {
        return repository.getById(id).orElseThrow(NotFoundException::new);
    }

    public Post save(Post post) {
        if (post.getId() == 0) {
            post.setId(Post.getNumOfPosts());
            return repository.save(post);
        } else {
            Post postToUpdate = repository.getById(post.getId()).orElseThrow(NotFoundException::new);
            postToUpdate.setContent(post.getContent());
            return repository.save(postToUpdate);
        }
    }

    public Post removeById(long id) {
        return repository.removeById(id).orElseThrow(NotFoundException::new);
    }
}

