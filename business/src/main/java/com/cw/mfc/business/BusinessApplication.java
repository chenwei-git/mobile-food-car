package com.cw.mfc.business;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@Slf4j
@MapperScan("com.cw.mfc.business.mapper")
public class BusinessApplication {


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(BusinessApplication.class, args);
        ConfigurableEnvironment env = run.getEnvironment();
        log.info("启动成功");
        log.info("测试地址：http://localhost:{}/business/test/hello",
                env.getProperty("server.port"));
    }

}