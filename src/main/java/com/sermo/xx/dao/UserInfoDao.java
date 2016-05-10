package com.sermo.xx.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserInfoDao {
	
	@Select("select count(email) from userInfo where password=#{password} and email=#{email}")
	public int login(@Param("password") String password, @Param("email") String email);
	
	@Select("select token from userInfo where email=#{email}")
	public String getToken(@Param("email") String email);
}
