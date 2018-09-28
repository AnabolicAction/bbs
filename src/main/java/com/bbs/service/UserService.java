package com.bbs.service;

import com.bbs.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
  Page<User> getList(Pageable pageable);
}
