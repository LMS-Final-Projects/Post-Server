package com.example.post.dto.request;


import com.example.post.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetRequest {
    private String userEmail;
    private Long majorId;
    public Post toEntity(){
        return Post
                .builder()
                .receiverEmail(userEmail)
                .checkPost(true)
                .build();
    }
}
