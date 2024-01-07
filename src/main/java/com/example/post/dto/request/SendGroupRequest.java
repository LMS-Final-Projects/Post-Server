package com.example.post.dto.request;

import com.example.post.entity.Post;
import com.example.post.entity.Type;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class SendGroupRequest {

    private String senderEmail;
    private String title;
    private String message;
    private String lectureId;

    public Post toEntity(){
        return Post
                .builder()
                .senderEmail(senderEmail)
                .title(title)
                .message(message)
                .sendTime(LocalDateTime.now())
                .checkPost(false)
                .build();
    }

}
