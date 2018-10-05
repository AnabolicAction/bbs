package com.bbs.service;

import com.bbs.domain.Post;

import java.util.List;

public interface PostManager {

    public List<Post> boardList(); //글목록

    public void postInsert(Post post); //글작성

    public Post postView(int bno); //글상세보기

    Post modifyView(int bno); //글수정 상세보기

    void postModify(Post post, int bno); //글 수정

    void postDelete(Post post); //글삭제
}
