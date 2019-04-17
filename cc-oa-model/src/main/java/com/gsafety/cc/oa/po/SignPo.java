package com.gsafety.cc.oa.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 签到信息
 *
 * @author hanhai.han
 * @since 12 四月 2019
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "oa_sign")
public class SignPo {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 签到日期
     */
    private LocalDate signDate;
    /**
     * 签到时间
     */
    private LocalTime signTime;
    /**
     * 创建时间
     */
    private transient LocalDateTime createTime;
    /**
     * 更新时间
     */
    private transient LocalDateTime updateTime;

}
