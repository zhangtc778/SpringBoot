package com.kevin.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kevin.bean.User;

@Mapper
public interface UserMapper {
	@Select("select * from sys_user t where t.name='乐银珠'")
	User findUserByName(@Param("name") String name);
}