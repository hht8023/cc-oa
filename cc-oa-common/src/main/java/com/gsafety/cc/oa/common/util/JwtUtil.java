package com.gsafety.cc.oa.common.util;

import com.gsafety.cc.oa.bo.LoginInfo;
import com.gsafety.cc.oa.bo.OperatorContext;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * JwtUtil
 *
 * @author hanhai.han
 * @since 15 四月 2019
 */
public class JwtUtil {

    private JwtUtil() {

    }

    static final String SECRET = "gsafety.cc";

    public static SecretKey generalKey(String secert) {
        byte[] encodedKey = secert.getBytes();
        return new SecretKeySpec(encodedKey, 0, encodedKey.length,
                "AES");
    }

    /**
     * @param id      用户ID
     * @param subject 用户标识
     * @param period  有效时间(秒)
     * @return
     */
    public static String generateToken(String id, String subject, long period) {
        return Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + period * 1000))// 过期时间
                .signWith(SignatureAlgorithm.HS512, generalKey(SECRET))
                .compact();
    }

    public static void validateToken(String token) {
        try {
            // parse the token.
            Claims claims = Jwts.parser().setSigningKey(generalKey(SECRET))
                    .parseClaimsJws(token)
                    .getBody();
            OperatorContext.setLoginInfo(LoginInfo.builder()
                    .userId(claims.getId())
                    .loginName(claims.getSubject())
                    .build());
        } catch (Exception e) {
            throw new IllegalStateException("Invalid Token. " + e.getMessage());
        }
    }

}
