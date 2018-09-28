package com.bbs.service;

import com.bbs.vo.PostVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("PostManager")
public class PostManagerImpl implements PostManager {


  @Override
  public PostVO getClass(PostVO postVO) {
    return null;
  }

  @Override
  public List<PostVO> boardList() throws Exception {
      PostVO postVO =new PostVO();
      postVO.getBno();
      postVO.getTitle();
      postVO.getRegDate();
      postVO.getPost();
      List<PostVO> postVOArrayList = new ArrayList<>();
    return postVOArrayList;
  }

  @Override
  public void postInsert(PostVO postVO) throws Exception {

  }

  @Override
  public PostVO postView(int bno) throws Exception {
    return null;
  }

  @Override
  public void hitPlus(int bno) throws Exception {

  }

  @Override
  public void boardUpdate(PostVO postVO) throws Exception {

  }

  @Override
  public void boardDelete(int bno) throws Exception {

  }
}
