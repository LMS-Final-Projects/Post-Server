package com.example.post.controller;

import com.example.global.response.LmsResponse;
import com.example.post.dto.request.*;
import com.example.post.dto.response.AllPostRes;
import com.example.post.dto.response.InfoResponse;
import com.example.post.dto.response.PostRes;
import com.example.post.service.PostService;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    
    //유저 유무 확인
    @GetMapping("/{email}")
    public LmsResponse<Boolean> getMember(@PathVariable("email") String email){
        Boolean result = postService.getMember(email);
        return new LmsResponse<>(HttpStatus.OK, result, "서비스 성공", "", LocalDateTime.now());
    }

    //쪽지 보내기
    @PostMapping("/sendPost")
    public LmsResponse<PostRes> sendPost(@RequestBody SendRequest request){
        PostRes postRes = postService.sendPost(request);
        return new LmsResponse<>(HttpStatus.OK, postRes, " 서비스 성공", "", LocalDateTime.now());
    };

    //쪽지 정보 보기
    @PostMapping("/getAll")
    public LmsResponse<List<PostRes>> getAllPost(@RequestBody GetRequest getRequest){
        List<PostRes> post = postService.getAllPost(getRequest);
        return new LmsResponse<>(HttpStatus.OK, post, "서비스 성공", "", LocalDateTime.now());
    };

    //쪽지 내용 보기
    @GetMapping("/getPostMessage")
    public LmsResponse<AllPostRes> getPostMessage(@RequestBody GetMessageRequest getMessageRequest){
        AllPostRes postMessage = postService.getPostMessage(getMessageRequest);
        return new LmsResponse<>(HttpStatus.OK, postMessage, "서비스 성공", "", LocalDateTime.now());
    }
    

    //단체 쪽지 보내기(교수)
    @PostMapping("/sendGroup")
    public LmsResponse<AllPostRes> sendGroupPostBy(@RequestBody SendGroupRequest request){

        AllPostRes allPostRes = postService.sendGroupPostByProfessor(request);
        return new LmsResponse<>(HttpStatus.OK, allPostRes, "서비스 성공", "", LocalDateTime.now());
    };



    //단체 쪽지 보내기(관리자)
    @PostMapping("/sendAll")
    public LmsResponse<AllPostRes> sendAllPostBy(@RequestBody SendGroupRequest request){

        AllPostRes allPostRes = postService.sendGroupPostByAdmin(request);
        return new LmsResponse<>(HttpStatus.OK, allPostRes, "서비스 성공", "", LocalDateTime.now());
    };

    //메일 삭제
    @PostMapping("/deletePosts")
    public LmsResponse<Void> deletePosts(@RequestBody DeleteRequest deleteRequest) {
        postService.deletePosts(deleteRequest);
        return new LmsResponse<>(HttpStatus.OK, null, "서비스 성공", "", LocalDateTime.now());
    }




}
