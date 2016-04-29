package com.sermo.xx;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.sermo.xx.dao.UserDao;

@SpringBootApplication
@MapperScan("com.sermo.xx.dao")
public class SpringbootmybatisApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootmybatisApplication.class, args);
	}
	
	@Autowired
	private UserDao userdao;
	
	@Override
	public void run(String... args) throws Exception {
		boolean flag = userdao.insertUser((int) Math.random() ,"renqing");
		System.out.println(flag);
		
		/*User user = userdao.selectId(1);
		System.out.println(user.getName());
		
		List<Map> list = userdao.select(1);
		System.out.println(list.get(0));*/
	}

}
