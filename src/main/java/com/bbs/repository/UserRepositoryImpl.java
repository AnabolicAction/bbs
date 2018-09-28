package com.bbs.repository;

import com.bbs.domain.QUser;
import com.bbs.domain.User;
import com.mysema.query.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositoryCustom {

  public UserRepositoryImpl() {
    super(User.class);
  }

  @Override
  public Page<User> getList(Pageable pageable) {
    QUser user = QUser.user;
    JPQLQuery query = from(user);

    query.orderBy(user.role.id.asc(), user.id.asc())
         .offset(pageable.getOffset()).limit(pageable.getPageSize());

    List<User> userList = query.list(user);
    long count = query.count();
    return new PageImpl<User>(userList, pageable, count);
  }
}
