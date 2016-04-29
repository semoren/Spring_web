package com.sermo.xx.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.sermo.xx.model.User;

public interface UserDao {
	
	@Select("select * from user where id=#{id}")
	public User selectId(@Param("id") Integer id);
	
	@Insert("insert into user values(#{id},#{name})")
	public boolean insertUser(@Param("id") Integer id, @Param("name") String name);
	
	@Select("select * from user u join user u1 where u.id=#{id}")
	public List<Map> select(@Param("id") Integer id);
	
}
