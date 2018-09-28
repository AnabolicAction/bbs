package com.bbs.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.bbs.AbstractTest;
import com.bbs.domain.User;
import com.bbs.repository.UserRepository;

public class UserServiceImplTest extends AbstractTest {

  @Autowired
  private UserRepository userRepository;

  @Before
  public void setUp() throws Exception {}

  @Test
  public void testFindAll() throws Exception {
    Pageable pageable = new PageRequest(0, 10);
    Page<User> page = userRepository.findAll(pageable);

    assertThat(page.getTotalElements(), is(26L));
  }

  @Test
  public void testEnabled() throws Exception {
    User user = userRepository.findOne("test");
    log.debug("@@{}:", user.isEnabled());
    log.debug("@@{}:", userRepository.findOne("test").isEnabled());
  }
}
