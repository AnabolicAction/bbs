package com.bbs.repository;

import com.bbs.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostRepositoryCustom {
  Page<Post> getList(Pageable pageable);
}
