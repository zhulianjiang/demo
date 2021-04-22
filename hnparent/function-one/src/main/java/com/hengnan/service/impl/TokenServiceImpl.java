package com.hengnan.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.hengnan.entity.UserAdmin;
import com.hengnan.service.TokenService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    private static final String TOKEN_HEAD = "Bearer";
    private static final String SEPARATOR = " ";

    /**
     * 生成token
     *
     * @param user
     * @return
     */
    public String getToken(UserAdmin user) {
        StringBuilder tokenSbr = new StringBuilder();
        Date startTime = new Date();
        // 设置token有效期一个小时
        long currentTime = System.currentTimeMillis() + 60 * 60 * 1000;
        Date endTime = new Date(currentTime);
        String token = JWT.create().withAudience(user.getId())
                .withIssuedAt(startTime).withExpiresAt(endTime)
                .sign(Algorithm.HMAC256(user.getPassWord()));
        return tokenSbr.append(TOKEN_HEAD).append(SEPARATOR).append(token).toString();
    }
}
