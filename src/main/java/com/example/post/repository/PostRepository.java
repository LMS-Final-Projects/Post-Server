package com.example.post.repository;

import com.example.post.entity.Post;
import com.example.post.dto.response.PostDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository
        extends JpaRepository<Post,Long> {

    @Query("select p from Post as p where p.receiverEmail = :userEmail or p.receiverEmail IN :lectureIds")
    List<PostDto> findAllByUserEmail(@Param("userEmail") String userEmail, @Param("lectureIds")List<Long> lectureIds);

    @Query("select m.message from Post as m where m.id = :id")
    Optional <PostDto> findMessageById(@Param("id")Long id);

    @Modifying
    @Query("DELETE FROM Post m WHERE m.id IN :ids")
    void deletePostByIdsQuery(@Param("ids") List<Long> postIds);

}
