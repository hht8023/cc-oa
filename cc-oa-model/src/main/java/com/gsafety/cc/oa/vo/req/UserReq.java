package com.gsafety.cc.oa.vo.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户信息
 *
 * @author hanhai.han
 * @since 16 四月 2019
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserReq {

    private String id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 登陆名
     */
    private String loginName;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
}
