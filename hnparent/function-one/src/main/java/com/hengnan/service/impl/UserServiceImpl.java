package com.hengnan.service.impl;

import com.hengnan.entity.User;
import com.hengnan.mapper.UserMapper;
import com.hengnan.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: leozhu
 * @create: 2020-12-06 16:54
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public List<User> getUserList(){
        List<User> userList = userMapper.getUserList();
        return userList;
    }

    @Override
    public User getUserById(Integer id) {
        User user = userMapper.getUserById(id);
        return user;
    }

}
