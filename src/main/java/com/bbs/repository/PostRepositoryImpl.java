package com.bbs.repository;

import com.bbs.domain.Post;
import com.bbs.domain.QPost;
import com.bbs.domain.QUser;
import com.bbs.domain.User;
import com.mysema.query.jpa.JPQLQuery;
import javafx.geometry.Pos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

public class PostRepositoryImpl extends QueryDslRepositorySupport implements PostRepositoryCustom {

  public PostRepositoryImpl() {
    super(Post.class);
  }

  @Override
  public Page<Post> getList(Pageable pageable) {
    QPost post = QPost.post1;
    JPQLQuery query = from(post);

    query.orderBy(post.member.memberId.asc(), post.bno.asc())
         .offset(pageable.getOffset()).limit(pageable.getPageSize());

    List<Post> postList = query.list(post);
    long count = query.count();
    return new PageImpl<Post>(postList, pageable, count);
  }
}
