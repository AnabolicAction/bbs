package com.bbs.service;

import com.bbs.domain.Post;

import java.util.List;

public interface PostManager {

//    PostVO getClass(PostVO postVO);
//
//    public List<PostVO> boardList() throws Exception; //글목록
//
//    public void postInsert(PostVO postVO) throws Exception; //글작성
//
//    public PostVO postView(int bno) throws Exception; //글보기
//
//    public void hitPlus(int bno) throws Exception; //조회수 증가
//
//    public void boardUpdate(PostVO postVO) throws Exception; //글 수정
//
//    public void boardDelete(int bno) throws Exception; //글 삭제


    public List<Post> boardList() ; //글목록

    public void postInsert(Post post) ; //글작성

    public Post postView(int bno) ; //글보기



    Post modifyView(int bno); //글수정 상세보기

    void postModify(Post post,int bno); //글 수정

    void postDelete(Post post); //글삭제
}
