package com.gsafety.cc.oa.controller;

import com.gsafety.cc.common.api.JsonResult;
import com.gsafety.cc.oa.biz.SignBiz;
import com.gsafety.cc.oa.vo.resp.ProjectResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * 签到
 *
 * @author hanhai.han
 * @since 15 四月 2019
 */
@RestController
@Slf4j
@RequestMapping("/api/sign")
public class SignController {

    @Resource
    private SignBiz signBiz;

    @GetMapping("/list/v1")
    public JsonResult<List<ProjectResp>> test(){
        return JsonResult.success(signBiz.findAll());
    }

}
