package com.gsafety.cc.oa.biz;

import com.gsafety.cc.common.annonation.Biz;
import com.gsafety.cc.oa.service.SignService;
import com.gsafety.cc.oa.vo.resp.ProjectResp;

import javax.annotation.Resource;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 签到
 *
 * @author hanhai.han
 * @since 12 四月 2019
 */
@Biz
public class SignBiz {

    @Resource
    private SignService signService;

    public List<ProjectResp> findAll() {
        return signService.findAll()
                .stream()
                .map(p -> ProjectResp.builder().id(p.getId())
                        .userId(p.getUserId())
                        .userName(p.getUserName())
                        .signDate(p.getSignDate())
                        .signTime(p.getSignTime())
                        .build())
                .collect(toList());
    }

}
