package com.gsafety.cc.oa.service;

import com.gsafety.cc.oa.po.UserPo;

/**
 * 系统登录
 *
 * @author hanhai.han
 * @since 15 四月 2019
 */
public interface UserService {
    /**
     * 根据登录名查找用户
     *
     * @param loginName
     * @return
     */
    UserPo findByLoginName(String loginName);

}
