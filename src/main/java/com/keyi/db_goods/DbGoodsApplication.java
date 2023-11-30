package com.keyi.db_goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController//用于标识以下函数是一个接口
@SpringBootApplication
public class DbGoodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbGoodsApplication.class, args);
	}

}
