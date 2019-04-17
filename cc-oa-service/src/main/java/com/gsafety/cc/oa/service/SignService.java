package com.gsafety.cc.oa.service;

import com.gsafety.cc.oa.po.SignPo;

import java.util.List;

/**
 * 签到
 *
 * @author hanhai.han
 * @since 15 四月 2019
 */
public interface SignService {


    List<SignPo> findAll();

}
