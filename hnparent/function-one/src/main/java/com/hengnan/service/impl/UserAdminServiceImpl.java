package com.hengnan.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hengnan.entity.UserAdmin;
import com.hengnan.entity.enums.StatusEnum;
import com.hengnan.mapper.test1.UserAdminMapper;
import com.hengnan.service.UserAdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: leozhu
 * @create: 2020-12-06 20:36
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class UserAdminServiceImpl implements UserAdminService {

    @Resource
    private UserAdminMapper userAdminMapper;

    @Override
    public List<UserAdmin> getList() {
        List<UserAdmin> userAdmins = userAdminMapper.selectList(new QueryWrapper<>());
        return userAdmins;
    }

    @Override
    public UserAdmin add(UserAdmin userAdmin) {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        userAdmin.setPassWord(DigestUtil.md5Hex(userAdmin.getPassWord()));
        userAdmin.setMobile(userAdmin.getLoginId());
        userAdmin.setCreationDate(timestamp);
        userAdmin.setLastUpdateDate(timestamp);
        userAdmin.setStatus(StatusEnum.NORMAL.value());
        userAdminMapper.insert(userAdmin);
        return userAdmin;
    }

    @Override
    public UserAdmin findById(String userId) {
        UserAdmin userAdmin = userAdminMapper.selectById(userId);
        return userAdmin;
    }

    @Override
    public UserAdmin findByLoginId(String loginId) {
        return userAdminMapper.selectOne(
                new QueryWrapper<UserAdmin>().lambda()
                        .eq(UserAdmin::getLoginId, loginId)
                        .eq(UserAdmin::getStatus, StatusEnum.NORMAL.value())
        );
    }
}
