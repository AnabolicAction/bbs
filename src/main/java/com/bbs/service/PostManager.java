package com.bbs.service;

import com.bbs.vo.PostVO;

import java.util.List;

public interface PostManager {

    PostVO getClass(PostVO postVO);

    public List<PostVO> boardList() throws Exception; //글목록

    public void postInsert(PostVO postVO) throws Exception; //글작성

    public PostVO postView(int bno) throws Exception; //글보기

    public void hitPlus(int bno) throws Exception; //조회수 증가

    public void boardUpdate(PostVO postVO) throws Exception; //글 수정

    public void boardDelete(int bno) throws Exception; //글 삭제

}
