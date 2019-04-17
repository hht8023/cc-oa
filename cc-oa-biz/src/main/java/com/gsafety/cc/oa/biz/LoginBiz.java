package com.gsafety.cc.oa.biz;

import com.gsafety.cc.common.agile.BizPreconditions;
import com.gsafety.cc.common.annonation.Biz;
import com.gsafety.cc.oa.common.constant.Constants;
import com.gsafety.cc.oa.common.util.JwtUtil;
import com.gsafety.cc.oa.common.util.MD5Utils;
import com.gsafety.cc.oa.po.UserPo;
import com.gsafety.cc.oa.service.UserService;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * 系统登录
 *
 * @author hanhai.han
 * @since 15 四月 2019
 */
@Biz
public class LoginBiz {

    @Resource
    private UserService userService;

    public String login(String loginName, String password) {
        UserPo user = userService.findByLoginName(loginName);
        // 用户是否存在
        BizPreconditions.checkArgumentNoStack(Objects.nonNull(user), Constants.Login.USERNAME_NO_EXIST);
        // 密码是否正确
        BizPreconditions.checkArgumentNoStack(StringUtils.equals(user.getPassword(), MD5Utils.string2MD5(password)), Constants.Login.USERNAME_PWD_ERROR);
        return JwtUtil.generateToken(user.getId(), user.getLoginName(), 60 * 1000);
    }

}
