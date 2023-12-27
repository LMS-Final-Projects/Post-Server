package com.example.post.dto.response;

import com.example.post.entity.Post;

import com.example.post.entity.Type;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class PostDto {

    private Long id;
    private String senderEmail;
    private String receiverEmail;
    private Type type;
    private String title;
    private String message;
    private boolean checkPost;
    private LocalDateTime sendTime;


    public PostDto(Post post) {
        this.id = post.getId();
        this.senderEmail = post.getSenderEmail();
        this.receiverEmail = post.getReceiverEmail();
        this.title = post.getTitle();
        this.message = post.getMessage();
        this.checkPost = false;
        this.sendTime = post.getSendTime();
        this.type = post.getType();
    }

    public PostDto(Long id, String senderEmail, String receiverEmail, Type type, String title, String message, boolean checkPost, LocalDateTime sendTime) {
        this.id = id;
        this.senderEmail = senderEmail;
        this.receiverEmail = receiverEmail;
        this.type = type;
        this.title = title;
        this.message = message;
        this.checkPost = checkPost;
        this.sendTime = sendTime;
    }

    public Post toEntity(){
        return Post
                .builder()
                .id(id)
                .title(title)
                .senderEmail(senderEmail)
                .receiverEmail(receiverEmail)
                .message(message)
                .checkPost(false)
                .sendTime(sendTime)
                .type(type)
                .build();
   }
}
