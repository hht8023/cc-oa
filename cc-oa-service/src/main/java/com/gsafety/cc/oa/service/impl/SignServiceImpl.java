package com.gsafety.cc.oa.service.impl;

import com.gsafety.cc.oa.po.SignPo;
import com.gsafety.cc.oa.service.SignService;
import com.gsafety.cc.oa.service.repository.SignRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SignServiceImpl implements SignService {

    @Resource
    private SignRepository signRepository;


    @Override
    public List<SignPo> findAll() {
        return signRepository.findAll();
    }
}
