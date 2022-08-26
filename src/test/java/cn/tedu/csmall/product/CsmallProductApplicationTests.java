package cn.tedu.csmall.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
public class CsmallProductApplicationTests {

    @Test
  public void contextLoads() {

    }
    @Autowired
    DataSource dataSource;

    @Test
    public void testGetConnection() throws SQLException {
        dataSource.getConnection();
    }


}
