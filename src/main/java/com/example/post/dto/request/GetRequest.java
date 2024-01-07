package com.example.post.dto.request;


import com.example.post.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetRequest {
    private String userEmail;
    private List<Long> lectureIds;
    public Post toEntity(){
        return Post
                .builder()
                .receiverEmail(userEmail)
                .checkPost(true)
                .build();
    }
}
