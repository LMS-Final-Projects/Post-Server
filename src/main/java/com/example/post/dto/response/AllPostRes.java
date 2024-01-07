package com.example.post.dto.response;
import com.example.post.entity.Post;
import com.example.post.entity.Type;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter

public class AllPostRes {

    private Long id;
    private String sendeEmail;
    private String receiverEmail;
    private String message;
    private Type type;
    private LocalDateTime sendTime;
    private boolean checkPost;
    private String title;

    public AllPostRes(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.sendeEmail = post.getSenderEmail();
        this.receiverEmail = post.getReceiverEmail();
        this.message = post.getMessage();
        this.sendTime = post.getSendTime();
        this.checkPost= false;
        this.type = post.getType();

    }


    public Post toEntity(){
        return  Post
                .builder()
                .id(id)
                .senderEmail(sendeEmail)
                .receiverEmail("ALL")
                .type(Type.ALL)
                .message(message)
                .sendTime(sendTime)
                .checkPost(false)
                .title(title)
                .build();
    }
}

