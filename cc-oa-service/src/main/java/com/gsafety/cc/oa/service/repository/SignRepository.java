package com.gsafety.cc.oa.service.repository;

import com.gsafety.cc.oa.po.SignPo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 签到信息
 *
 * @author hanhai.han
 * @since 12 四月 2019
 */
public interface SignRepository extends JpaRepository<SignPo, Integer> {



}
