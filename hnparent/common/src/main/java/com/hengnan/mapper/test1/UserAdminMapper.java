package com.hengnan.mapper.test1;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hengnan.entity.UserAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserAdminMapper extends BaseMapper<UserAdmin> {

}
