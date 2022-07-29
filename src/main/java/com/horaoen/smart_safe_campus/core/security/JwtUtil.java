package com.horaoen.smart_safe_campus.core.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;

import java.util.Calendar;
import java.util.Map;

public class JwtUtil {
    //密钥
    @Value("${security.jwt.secret}")
    private static String SECRET = "!Q464rwr(&*)6%$#^%&JNJ46da";

    /**
     * 生成token
     * @param map:要加密的信息
     * @return 令牌
     */
    public static String sign(Map<String, String> map) {
        //设置过期时间 默认3天
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 3);
        JWTCreator.Builder builder = JWT.create();
        //payload
        map.forEach(builder::withClaim);
        //指定令牌过期时间与加密
        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    /**
     * 验证token合法性/获取token全部信息
     * @param token
     * @return verify
     */
    public static DecodedJWT verify(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
    }

    /**
     * 获取token单个信息
     * @param token
     * @param s:key
     * @return value
     */
    public static String getInfo(String token, String s) {
        DecodedJWT verify = verify(token);
        return verify.getClaim(s).asString();
    }
}
