package com.gsafety.cc.oa.vo.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 项目信息
 *
 * @author hanhai.han
 * @since 12 四月 2019
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectResp {

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

}
