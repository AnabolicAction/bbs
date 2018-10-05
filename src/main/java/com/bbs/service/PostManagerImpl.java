package com.bbs.service;

import com.bbs.domain.Post;
import com.bbs.repository.PostRepository;
import com.bbs.repository.PostRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PostManager")
public class PostManagerImpl implements PostManager {

    @Autowired
    private PostRepository postRepository;

    @Override //리스트 뿌리기
    public List<Post> boardList() {
//        List<Post> postVOArrayList = postRepository.findAll();
        return postRepository.findAll();
    }

    @Override  //글작성 저장
    public void postInsert(Post post) {
        //post.setHit(0);
        postRepository.save(post);

    }


    @Override
    public Post postView(int bno) {
        // 글 상세보기
        Post post = postRepository.findOne(bno);
        //Post post=postRepositoryImpl.getPostById(bno);
        System.out.println("클릭 : "+post.getHit());
        post.setHit(post.getHit()+1); //조회수 증가
        postRepository.save(post);
        return post;
    }

    @Override
    public Post modifyView(int bno) {
        // modify 글 상세보기
        Post post = postRepository.findOne(bno);
        return post;
    }


    @Override
    public void postModify(Post post,int bno) {  //수정된것 저장
       Post postModify= postRepository.findOne(bno);
        postModify.setPost(post.getPost());
        postModify.setTitle(post.getTitle());
        postModify.setUpDate(post.getUpDate());
        postRepository.save(postModify);

    }


    @Override
    public void postDelete(Post post) { //삭제
        postRepository.delete(post);

    }

}
