package com.example.post.service;

import com.example.global.exception.NotFoundException;
import com.example.post.dto.request.*;
import com.example.post.dto.response.AllPostRes;
import com.example.post.dto.response.PostDto;
import com.example.post.dto.response.PostRes;
import com.example.post.entity.Post;
import com.example.post.entity.Type;
import com.example.post.repository.MemberRepository;
import com.example.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    //쪽지 보내기
    //유저 유무 확인.
    @Transactional
    public Boolean getMember(String email){
        memberRepository.findByEmail(email).orElseThrow(()->new NotFoundException("해당 유저가 없습니다."));
        return true;
    }

    @Transactional
    public PostRes sendPost(SendRequest request){
        Post save = postRepository.save(request.toEntity());
        PostRes postRes = new PostRes(save);
        return postRes;

    };

    //쪽지 제목 보기
    @Transactional
    public List<PostRes> getAllPost(GetRequest getRequest){
        List<PostDto> postDtoList = postRepository.findAllByUserEmail(getRequest.getUserEmail(), getRequest.getLectureIds());
        List<PostRes> resultList = new ArrayList<>();
        for(PostDto post : postDtoList){
            resultList.add(new PostRes(post.toEntity()));
        }
        return resultList;
    };

    //쪽지 내용보기
    public AllPostRes getPostMessage(GetMessageRequest getMessageRequest){
        PostDto postDto = postRepository.findMessageById(getMessageRequest.getId()).get();
        AllPostRes allPostRes = new AllPostRes(postDto.toEntity());
        return allPostRes;
    }



    //단체 쪽지 보내기(교수)
    public AllPostRes sendGroupPostByAdmin(SendGroupRequest request){
        Post save = postRepository.save(
                Post
                        .builder()
                        .senderEmail(request.getSenderEmail())
                        .receiverEmail(request.getLectureId())
                        .type(Type.LECTURE)
                        .title(request.getTitle())
                        .message(request.getMessage())
                        .sendTime(LocalDateTime.now())
                        .checkPost(false)
                        .build()
        );
        AllPostRes allPostRes = new AllPostRes(save);
        return allPostRes;
    };


    //단체 쪽지 보내기(관리자)
    public AllPostRes sendGroupPostByProfessor(SendGroupRequest request){
        Post save = postRepository.save(
                Post
                        .builder()
                        .senderEmail(request.getSenderEmail())
                        .receiverEmail("All")
                        .type(Type.ALL)
                        .title(request.getTitle())
                        .message(request.getMessage())
                        .sendTime(LocalDateTime.now())
                        .checkPost(false)
                        .build()
        );
        AllPostRes allPostRes = new AllPostRes(save);
        return allPostRes;
    };

    
    //메일 삭제
    @Transactional
    public void deletePosts(DeleteRequest deleteRequest) {
            postRepository.deletePostByIdsQuery(deleteRequest.getPostIds());}

}
