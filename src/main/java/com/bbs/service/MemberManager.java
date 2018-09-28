package com.bbs.service;

import com.bbs.domain.User;
import com.bbs.vo.MemberVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberManager {

    MemberVO getClass(MemberVO memberVO);
}
