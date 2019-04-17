package com.gsafety.cc.oa.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 系统用户
 *
 * @author hanhai.han
 * @since 15 四月 2019
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "oa_user")
public class UserPo {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    /**
     * 用户名称
     */
    private String name;
    /**
     * 登陆名
     */
    private String loginName;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 是否删除
     */
    private boolean del;
    /**
     * 创建时间
     */
    private transient LocalDateTime createTime;
    /**
     * 更新时间
     */
    private transient LocalDateTime updateTime;

}
