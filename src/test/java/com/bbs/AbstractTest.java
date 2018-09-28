package com.bbs;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(BbsApplication.class)
@WebAppConfiguration
public class AbstractTest extends AbstractTransactionalJUnit4SpringContextTests {

  protected final Logger log = LoggerFactory.getLogger(getClass());

}
