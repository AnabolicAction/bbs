package com.bbs.repository;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbs.AbstractTest;
import com.bbs.domain.User;

public class UserRepositoryTest extends AbstractTest {

  @Autowired
  private UserRepository userRepository;

  private User user;

  @Before
  public void setUp() {
    user = userRepository.findOne("test");
    assertThat(userRepository.count(), is(26L));
  }

  @Test
  public void testFind() {
    assertThat("ROLE_USER", is(user.getRole().getAuthority()));
  }

  @Test
  public void testFindAll() {
    List<User> userList = userRepository.findAll();
    assertThat(userList.size(), is(26));
  }

  @Test
  public void testUpdate() {
    user.setPassword("4321");
    userRepository.save(user);

    User updateUser = userRepository.findOne(user.getId());
    assertThat(user.getPassword(), is(updateUser.getPassword()));
  }

  @Test
  public void testDelete() {
    assertNotNull(user);
    userRepository.delete(user);

    User deleteUser = userRepository.findOne(user.getId());
    assertNull(deleteUser);
  }
}
