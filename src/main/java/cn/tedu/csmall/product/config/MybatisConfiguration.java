package cn.tedu.csmall.product.config;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@MapperScan("cn.tedu.csmall.product.mapper")
public class MybatisConfiguration {
    public MybatisConfiguration() {
        log.info("加载配置类：MybatisConfiguration");
    }
}

