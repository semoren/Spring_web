package com.sermo.xx.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.sermo.xx.model.UserInfo;
import com.sermo.xx.vo.UserInfoVo;

public interface UserInfoDao {
	
	@Select("select count(email) from userInfo where password=#{password} and email=#{email}")
	public int login(@Param("password") String password, @Param("email") String email);
	
	@Select("select count(id) from userInfo where email = #{email}")
	public int emailIsExits(@Param("email") String email);
	
	@Select("select token from userInfo where email=#{email}")
	public String getToken(@Param("email") String email);
	
	@Select("select email, password, token from userInfo where email=#{email}")
	public UserInfoVo getInfoVo(@Param("email") String email);
	
	@Insert("insert into userInfo(id, email, userName, password, token, createTime) values(#{userInfo.id}, #{userInfo.email}, #{userInfo.username}, #{userInfo.password}, #{userInfo.token}, #{userInfo.createTime})")
	public boolean insert(@Param("userInfo") UserInfo userInfo);
	
	@Update("update userInfo set reset_key=#{resetKey} where email=#{email}")
	public boolean updateKey(@Param("email") String email, @Param("resetKey") String resetKey);
	
	@Select("select count(email) from userInfo where reset_key=#{resetKey} and email=#{email}")
	public int selectByKey(@Param("email") String email, @Param("resetKey") String resetKey);
}
