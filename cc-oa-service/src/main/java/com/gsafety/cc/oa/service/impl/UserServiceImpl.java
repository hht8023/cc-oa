package com.gsafety.cc.oa.service.impl;

import com.gsafety.cc.oa.po.UserPo;
import com.gsafety.cc.oa.service.UserService;
import com.gsafety.cc.oa.service.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 系统登录
 *
 * @author hanhai.han
 * @since 15 四月 2019
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;


    @Override
    public UserPo findByLoginName(String loginName) {
        return userRepository.findByLoginNameAndDel(loginName, false);
    }
}
