package com.bbs;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ContextConfiguration
public class AbstractControllerTests extends AbstractTest {

  @Inject
  private WebApplicationContext wac;

  protected MockMvc mockMvc;

  protected MessageSourceAccessor messages;

  @Inject
  public void setMessages(MessageSource messageSource) {
    messages = new MessageSourceAccessor(messageSource);
  }

  @Before
  public void setup() {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).apply(springSecurity()).build();
  }

  public MockHttpServletRequest newPost(String url) {
    return new MockHttpServletRequest("POST", url);
  }

  public MockHttpServletRequest newGet(String url) {
    return new MockHttpServletRequest("GET", url);
  }

  @After
  public void teardown() {
    SecurityContextHolder.clearContext();
  }

}