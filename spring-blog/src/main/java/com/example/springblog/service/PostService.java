package com.example.springblog.service;

import com.example.springblog.dto.PostDto;
import com.example.springblog.exceptions.PostNotFoundException;
import com.example.springblog.model.Post;
import com.example.springblog.repository.PostRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final AuthService authService;
    private final PostRepository postRepository;

    public PostService(AuthService authService, PostRepository postRepository) {
        this.authService = authService;
        this.postRepository = postRepository;
    }

    public void createPost(PostDto postDto) {
        Post post = mapDtoToPost(postDto);
        postRepository.save(post);
    }

    public List<PostDto> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(this::mapPostToDto)
                .collect(Collectors.toList());
    }

    public PostDto findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("For ID " + id));
        return mapPostToDto(post);
    }

    private Post mapDtoToPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        User user = authService.getCurrentUser()
                .orElseThrow(() -> new IllegalArgumentException("No User logged in"));
        post.setUsername(user.getUsername());
        post.setCreatedOn(Instant.now());
        return post;
    }

    private PostDto mapPostToDto(Post post) {
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setUsername(post.getUsername());
        return dto;
    }
}
