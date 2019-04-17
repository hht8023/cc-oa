package com.gsafety.cc.oa.controller;

import com.gsafety.cc.common.agile.ParamPreconditions;
import com.gsafety.cc.common.api.JsonResult;
import com.gsafety.cc.oa.biz.LoginBiz;
import com.gsafety.cc.oa.vo.req.UserReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * LoginController
 *
 * @author hanhai.han
 * @since 15 四月 2019
 */
@RestController
@Slf4j
@RequestMapping("/sys")
public class LoginController {

    @Resource
    private LoginBiz loginBiz;

    @PostMapping("/login/v1")
    public JsonResult<String> login(@RequestBody UserReq userReq) {
        log.info(" 当前登录用户 {} ", userReq.getLoginName());
        ParamPreconditions.notEmpty(userReq.getLoginName(), "用户名不能为空!");
        ParamPreconditions.notEmpty(userReq.getPassword(), "密码不能为空!");
        return JsonResult.success(loginBiz.login(userReq.getLoginName(), userReq.getPassword()));
    }

}
