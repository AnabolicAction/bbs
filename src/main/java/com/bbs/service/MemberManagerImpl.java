package com.bbs.service;

import com.bbs.domain.User;
import com.bbs.repository.MemberRepository;
import com.bbs.repository.UserRepository;
import com.bbs.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("MemberManager")
public class MemberManagerImpl implements MemberManager {

  @Autowired
  private MemberRepository memberRepository;

  @Override
  public MemberVO getClass(MemberVO memberVO) {
    return null;
  }
}
