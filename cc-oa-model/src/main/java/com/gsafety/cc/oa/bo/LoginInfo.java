package com.gsafety.cc.oa.bo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * LoginInfo
 *
 * @author hanhai.han
 * @since 16 四月 2019
 */
@Getter
@Setter
@Builder
public class LoginInfo {

    /**
     * 用户ID
     */
    private String userId;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 中文名
     */
    private String cnName;
    /**
     * 邮箱
     */
    private String email;
}
