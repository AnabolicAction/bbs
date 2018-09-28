package com.bbs.repository;

import com.bbs.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepositoryCustom {
  Page<User> getList(Pageable pageable);
}
