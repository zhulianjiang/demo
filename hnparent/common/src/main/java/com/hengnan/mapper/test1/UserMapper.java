package com.hengnan.mapper.test1;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hengnan.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

    //    @Select("select * from user")
    List<User> getUserList();

    User getUserById(@Param("id") Integer id);

}
