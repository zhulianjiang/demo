package com.hengnan.service;

import com.hengnan.entity.UserAdmin;

public interface TokenService {
    String getToken(UserAdmin user);
}
