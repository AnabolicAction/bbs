package com.bbs.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bbs.domain.User;
import com.bbs.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
    User user = userRepository.findOne(id); //id로 유저정보를 가지고오기위해
    if (user == null) {
      throw new UsernameNotFoundException("Unknown ID");
    }
    return user;
  }

  @Override
  public Page<User> getList(Pageable pageable) {
    return null;
  }
}
