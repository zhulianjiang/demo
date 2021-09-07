package com.hengnan.service;

import com.hengnan.entity.User;

import java.util.List;

public interface UserService {

    /**
     * 查询用户List
     *
     * @return
     */
    List<User> getUserList();

    /**
     * 根据用户id查询
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);

}
