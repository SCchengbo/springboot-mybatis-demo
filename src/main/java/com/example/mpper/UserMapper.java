package com.example.mpper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM USERS WHERE NAME = #{name}")
	List<com.example.entity.User> findByName(@Param("name") String name);

	@Insert("INSERT INTO USERS(NAME, AGE) VALUES(#{name}, #{age})")
	int insert(@Param("name") String name, @Param("age") Integer age);

	@Delete("DELETE FROM USERS WHERE AGE=#{age}")
	void delete(@Param("age") int age);

	@Update("UPDATE  USERS SET AGE=#{age}  WHERE NAME=#{name}")
	void update(@Param("name") String name, @Param("age") int age);

}
