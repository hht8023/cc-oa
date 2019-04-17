package com.gsafety.cc.oa.service.repository;

import com.gsafety.cc.common.repository.BaseRepository;
import com.gsafety.cc.oa.po.UserPo;

/**
 * 用户信息
 *
 * @author hanhai.han
 * @since 15 四月 2019
 */
public interface UserRepository extends BaseRepository<UserPo, Integer> {

    UserPo findByLoginNameAndDel(String loginName, boolean del);

}
