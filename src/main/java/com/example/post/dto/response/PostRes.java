package com.example.post.dto.response;

import com.example.post.entity.Post;
import com.example.post.entity.Type;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class PostRes {

    private Long id;
    private String senderEmail;
    private String receiverEmail;
    private String message;
    private Type type;
    private LocalDateTime sendTime;
    private boolean checkPost;
    private String title;

    public PostRes(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.senderEmail = post.getSenderEmail();
        this.receiverEmail = post.getReceiverEmail();
        this.message = post.getMessage();
        this.sendTime = post.getSendTime();
        this.checkPost= false;
        this.type = post.getType();

    }

    public PostRes(Long id, String senderEmail, String receiverEmail, String message, Type type, LocalDateTime sendTime, boolean checkPost, String title) {
        this.id = id;
        this.senderEmail = senderEmail;
        this.receiverEmail = receiverEmail;
        this.message = message;
        this.type = type;
        this.sendTime = sendTime;
        this.checkPost = checkPost;
        this.title = title;
    }

    public Post toEntity(){
        return  Post
                .builder()
                .id(id)
                .senderEmail(senderEmail)
                .receiverEmail(receiverEmail)
                .message(message)
                .sendTime(sendTime)
                .checkPost(false)
                .title(title)
                .build();
    }
}

