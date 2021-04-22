package com.hengnan.service;


import com.hengnan.entity.UserAdmin;

import java.util.List;

public interface UserAdminService {

    List<UserAdmin> getList();

    UserAdmin add(UserAdmin userAdmin);

    UserAdmin findById(String userId);

    UserAdmin findByLoginId(String loginId);

}
