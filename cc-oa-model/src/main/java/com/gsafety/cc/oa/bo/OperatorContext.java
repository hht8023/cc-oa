package com.gsafety.cc.oa.bo;

/**
 * OperatorContext
 *
 * @author hanhai.han
 * @since 15 四月 2019
 */
public class OperatorContext{

    private static final ThreadLocal<LoginInfo> LOGIN_INFO_THREAD_LOCAL = new ThreadLocal<>();

    public OperatorContext() {
    }


    public static LoginInfo getLoginInfo() {
        return LOGIN_INFO_THREAD_LOCAL.get();
    }

    public static void setLoginInfo(LoginInfo loginInfo) {
        LOGIN_INFO_THREAD_LOCAL.set(loginInfo);
    }

    public static void release() {
        LOGIN_INFO_THREAD_LOCAL.remove();
    }

}
