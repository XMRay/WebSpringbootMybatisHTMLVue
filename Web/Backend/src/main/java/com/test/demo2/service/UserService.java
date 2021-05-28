package com.test.demo2.service;
import com.test.demo2.entity.User;
import com.test.demo2.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserService {
    @Autowired
    private UserDao userDao;
    public User queryUser(int id){
        return userDao.getUserById(id);
    }
    public User queryDelUser(int id){
        return userDao.delUser(id);
    }
    public User queryaddUser(int id,String username,String des,int age){return userDao.addUser(id,username,des,age);}
    public User querychangeUser(int oldid,int id,String username,String des,int age){return userDao.changeUser(oldid,id,username,des,age);}
//    public List<User> queryUser2(int age){
//        return userDao.getUserByAge(age);
//    }
    public List<User> queryUserAll(){
        return userDao.getUserAll();
    }
}

/*传递多个参数我们可以用 Map 来实现
public List<User> queryUser4(Integer age, Integer start, Integer move){
    Map<String,Object> hashMap=new HashMap<>();
    hashMap.put("age",age);
    hashMap.put("start",start);
    hashMap.put("move",move);
    return userDao.selectById4(hashMap);
}
*/
