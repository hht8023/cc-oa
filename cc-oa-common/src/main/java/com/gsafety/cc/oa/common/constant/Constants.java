package com.gsafety.cc.oa.common.constant;

import java.time.LocalTime;

/**
 * 配置常量
 *
 * @author haitao.han
 * @date 15 四月 2019
 */
public interface Constants {

    /**
     * 登录
     */
    interface Login{

        String AUTHORIZATION = "token";

        String UNAUTHORIZED = "无权限";

        String USERNAME_NO_EXIST = "用户不存在!";

        String USERNAME_PWD_ERROR = "用户名或密码错误!";


    }


}
