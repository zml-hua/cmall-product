package cn.tedu.csmall.product.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;

@Slf4j
@Configuration
public class ValidationConfiguration {

    public ValidationConfiguration() {
        log.info("加载配置类：ValidationConfiguration");
    }

    @Bean
    public javax.validation.Validator vvv(){
        return Validation.byProvider(HibernateValidator.class)
                //我爱你
                .configure() //开始配置Validator
                .failFast(true) //快速失败，检查到错误就直接视为失败
                .buildValidatorFactory()
                .getValidator();
    }
}
