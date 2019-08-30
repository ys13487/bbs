package com.bbs.ys.bbs;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.bbs.ys.bbs.dao")
public class BbsApplication {

	public static void main(String[] args) {

		SpringApplication.run(BbsApplication.class, args);
	}

}

