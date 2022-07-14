package com.fu.gradledemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan("com.fu.gradledemo.mapper")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class GradledemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(GradledemoApplication.class, args);
    }
}
