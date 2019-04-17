package com.gsafety.cc.oa.config;

import com.gsafety.cc.oa.common.constant.Constants;
import com.gsafety.cc.oa.common.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JwtAuthenticationFilter
 *
 * @author hanhai.han
 * @since 15 四月 2019
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final PathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            String token = req.getHeader(Constants.Login.AUTHORIZATION);
            if(isProtectedUrl(req) && StringUtils.isNotBlank(token)) {
                //检查jwt令牌, 如果令牌不合法或者过期, 里面会直接抛出异常, 下面的catch部分会直接返回
                JwtUtil.validateToken(token);
            }
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, Constants.Login.UNAUTHORIZED);
            return;
        }
        //如果jwt令牌通过了检测, 那么就把request传递给后面的RESTful api
        filterChain.doFilter(req, resp);
    }

    //我们只对地址 /api 开头的api检查jwt. 不然的话登录/login也需要jwt
    private boolean isProtectedUrl(HttpServletRequest request) {
        return pathMatcher.match("/api/**", request.getServletPath());
    }

}
