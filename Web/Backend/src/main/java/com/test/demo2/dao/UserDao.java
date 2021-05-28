package com.test.demo2.dao;

import com.test.demo2.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
实现两个功能
	1、根据用户id查询用户信息
	2、查询同一年龄下的所有用户

返回一组数据我们用 List<E> 来存储，传递多个参数我们用 Map 来存储
例如 public List<User> selectById4(@Param("map") Map map);
*/
@Repository
public interface UserDao {
    //使用@Param
    public User getUserById(@Param("id") int id);

    public User delUser(@Param("id") int id);

    public User addUser(@Param("id") int id,@Param("username") String username,@Param("des") String des,@Param("age") int age);

    public User changeUser(@Param("oldid") int oldid,@Param("id") int id,@Param("username") String username,@Param("des") String des,@Param("age") int age);

//    public List<User> getUserByAge(@Param("age") int age);

    public List<User> getUserAll();
}

