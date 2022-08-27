package cn.tedu.csmall.product;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

@Slf4j
public class DigestTests {

    @Test
    public void testEncode(){
        String rawPassword = "123456";
        String encodedPassword = DigestUtils.md5DigestAsHex(rawPassword.getBytes());
        log.debug("原始密码={}，MD5运算结果={}", rawPassword, encodedPassword);

    }
}
