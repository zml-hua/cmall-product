package cn.tedu.csmall.product;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class Slf4jTests {

    @Test
    public void testSl4js(){
        log.trace("这是TRANCE级别的日志");
        log.debug("这是DEBUG级别的日志");
        log.info("这是INFO级别的日志");
        log.warn("这是WARN级别的日志");
        log.error("这是ERRORE级别的日志");
    }
}
