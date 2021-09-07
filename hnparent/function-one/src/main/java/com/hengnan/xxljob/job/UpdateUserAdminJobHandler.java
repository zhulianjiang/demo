package com.hengnan.xxljob.job;

import com.hengnan.entity.UserAdmin;
import com.hengnan.mapper.test1.UserAdminMapper;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @description:
 * @author: leozhu
 * @create: 2020/12/22 16:26
 **/
@Component
public class UpdateUserAdminJobHandler {

    private static final String userId = "736ae9aabd8f9651c988899dec39f7fb";

    @Autowired
    private UserAdminMapper userAdminMapper;

    @XxlJob("updateUserAdminJobHandler")
    public ReturnT<String> execute(String param) throws Exception {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        UserAdmin userAdmin = userAdminMapper.selectById(userId);
        if (Objects.nonNull(userAdmin)) {
            userAdmin.setCreationDate(timestamp);
            userAdmin.setLastUpdateDate(timestamp);
            userAdmin.setFirstName("1234");
            userAdminMapper.updateById(userAdmin);
        }
        return ReturnT.SUCCESS;
    }

}
