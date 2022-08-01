package com.horaoen.smart_safe_campus.service.impl;

import com.horaoen.smart_safe_campus.common.api.CommonResult;
import com.horaoen.smart_safe_campus.core.security.JwtToken;
import com.horaoen.smart_safe_campus.core.security.JwtUtil;
import com.horaoen.smart_safe_campus.dao.UserDao;
import com.horaoen.smart_safe_campus.mbg.model.User;
import com.horaoen.smart_safe_campus.model.dto.LoginDto;
import com.horaoen.smart_safe_campus.service.AuthService;
import com.horaoen.smart_safe_campus.service.RedisService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private UserDao userDao;
    @Value("${spring.redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${spring.redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;
    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public CommonResult generateAuthCode(String telephone) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        //验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(sb.toString(), "获取验证码成功");
    }

    @Override
    public CommonResult verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isEmpty(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        boolean result = authCode.equals(realAuthCode);
        if (result) {
            return CommonResult.success(null, "验证码校验成功");
        } else {
            return CommonResult.failed("验证码不正确");
        }
    }

    @Override
    public CommonResult login(LoginDto loginUser) {
        Subject currentUser = SecurityUtils.getSubject();

        if(!currentUser.isAuthenticated()) {
            User user = userDao.findUserByUsername(loginUser.getUserName());
            if (user == null) {
                return CommonResult.failed("用户不存在");
            }
            try {
                String jwtToken = JwtUtil.sign(loginUser.getUserName(), loginUser.getPassword());
                SecurityUtils.getSubject().login(new JwtToken(jwtToken));
                return CommonResult.success(jwtToken, "登录成功");
            } catch (UnknownAccountException e) {
                return CommonResult.failed("账号不存在");
            } catch (Exception e) {
                return CommonResult.failed("登录失败");
            }
        } else {
            return CommonResult.success("已经登录");
        }
    }


}
