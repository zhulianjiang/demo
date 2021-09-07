package com.hengnan.handler;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.hengnan.base.PassToken;
import com.hengnan.core.exception.http.ForbiddenException;
import com.hengnan.core.exception.http.NotFondException;
import com.hengnan.entity.UserAdmin;
import com.hengnan.service.UserAdminService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 拦截器
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    private static final String SEPARATOR = " ";

    @Autowired
    UserAdminService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) {
        // 从 http 请求头中取出 Authorization
        String bearerToken = httpServletRequest.getHeader("Authorization");
        String token = null;
        if (StringUtils.isNotBlank(bearerToken)) {
            token = Arrays.asList(bearerToken.split(SEPARATOR)).get(1);
        }
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        if (token == null) {
            throw new ForbiddenException(100001001);
        }
        // 获取 token 中的 user id
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new ForbiddenException(100001002);
        }
        UserAdmin user = userService.findById(userId);
        if (user == null) {
            throw new NotFondException(100001003);
        }
        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassWord())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            throw new ForbiddenException(100001002);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}