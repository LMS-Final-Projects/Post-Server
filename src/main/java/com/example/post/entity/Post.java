package com.example.post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String senderEmail;
    private String receiverEmail; //개인 이면 개인 UUID,  과목 Id, 전체면 전체 메시지 ALL.
    private Type type; // UUID, LONG, ALL
    private String title;
    private String message;
    private boolean checkPost;
    private LocalDateTime sendTime;

}
