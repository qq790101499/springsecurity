package com.platform.zxx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
@MapperScan("com.platform.zxx.dao")
public class ZxxApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZxxApplication.class, args);
	}
}
