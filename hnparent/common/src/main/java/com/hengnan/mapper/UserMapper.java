package com.hengnan.mapper;

import com.hengnan.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
public interface UserMapper {

//    @Select("select * from user")
    List<User> getUserList();

    User getUserById(@Param("id") Integer id);

}
