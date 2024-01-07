package com.example.post.dto.request;


import com.example.post.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GetMessageRequest {

    private Long id;
    private String senderEmail;
    private String receiverEmail;
    private String message;

    public Post toEntity(){
        return Post
                .builder()
                .id(id)
                .senderEmail(senderEmail)
                .receiverEmail(receiverEmail)
                .message(message)
                .sendTime(LocalDateTime.now())
                .checkPost(false)
                .build();
    }
}
