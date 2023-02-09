package com.jxd.leave;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName UserApplication
 * @Description TODO
 * @Author fengyuhao
 * @Date 2023/1/27
 * @Version 1.0
 */
@SpringBootApplication
@MapperScan("com.jxd.leave.dao")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class);
    }
}
