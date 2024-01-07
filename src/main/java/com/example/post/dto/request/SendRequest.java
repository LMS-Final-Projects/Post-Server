package com.example.post.dto.request;

import com.example.post.entity.Post;
import com.example.post.entity.Type;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class SendRequest {

    private String receiverEmail;
    private String title;
    private String senderEmail;
    private String message;
    private Type type;

    public Post toEntity(){
        return Post
                .builder()
                .receiverEmail(receiverEmail)
                .senderEmail(senderEmail)
                .message(message)
                .title(title)
                .sendTime(LocalDateTime.now())
                .type(type)
                .checkPost(false)
                .build();
    }

}
