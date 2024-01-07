package com.example.post.dto.request;

import com.example.post.entity.Post;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class DeleteRequest {

    private List<Long> postIds;

    public List<Post> toEntities() {
        return postIds.stream()
                .map(id -> Post.builder().id(id).build())
                .collect(Collectors.toList());
    }
}
