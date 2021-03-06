package com.bbs;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BbsApplication.class)
@WebAppConfiguration
public class BbsApplicationTests {

  @Autowired
  private DataSource dataSource;

  @Test
  public void testDataSource() {
    assertNotNull(dataSource);
  }

  @Test
  public void testConnection() throws SQLException {
    Connection con = dataSource.getConnection();
    assertNotNull(con);
    con.close();
  }
}
