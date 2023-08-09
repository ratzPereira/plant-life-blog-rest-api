package com.ratz.blog.service.impl;

import com.ratz.blog.DTO.PostDTO;
import com.ratz.blog.entity.Post;
import com.ratz.blog.repository.PostRepository;
import com.ratz.blog.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {

        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setImages(postDTO.getImages());
        post.setDescription(postDTO.getDescription());

        Post newPost = postRepository.save(post);

        PostDTO postResponse = new PostDTO();
        postResponse.setId(newPost.getId());
        postResponse.setTitle(newPost.getTitle());
        postResponse.setContent(newPost.getContent());
        postResponse.setImages(newPost.getImages());
        postResponse.setDescription(newPost.getDescription());

        return postResponse;
    }
}
