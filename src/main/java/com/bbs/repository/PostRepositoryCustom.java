package com.bbs.repository;

import com.bbs.domain.Post;

import java.util.List;

public interface PostRepositoryCustom {
  List<Post> getList();
  public Post getPostById(int bno);

}
