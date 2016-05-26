package com.sermo.xx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sermo.xx.dao")
public class BootMain{

	/*static{
		try {
			// 初始化 log4j
			String log4jPath = BootMain.class.getClassLoader().getResource("").getPath()+"/log4j.properties";
			System.out.println("初始化 Log4j ...");
			System.out.println("path is " + log4jPath);
			PropertyConfigurator.configure(log4jPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(BootMain.class, args);
	}
}
