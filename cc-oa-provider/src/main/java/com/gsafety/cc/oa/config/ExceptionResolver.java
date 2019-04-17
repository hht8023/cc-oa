package com.gsafety.cc.oa.config;

import com.gsafety.cc.common.api.JsonResult;
import com.gsafety.cc.common.constant.ErrorStatusCode;
import com.gsafety.cc.common.exception.BusinessCheckException;
import com.gsafety.cc.common.exception.BusinessException;
import com.gsafety.cc.common.exception.ParamException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * JwtAuthenticationFilter
 *
 * @author hanhai.han
 * @since 15 四月 2019
 */
@Slf4j
@RestControllerAdvice
public class ExceptionResolver {
    /**
     * default 系统异常
     */
    private static final String SYSTEM_EXCEPTION_MESSAGE = "系统异常";
    /**
     * default 业务异常
     */
    private static final String BUSINESS_EXCEPTION_MESSAGE = "业务异常";
    /**
     * default 参数异常
     */
    private static final String PARAM_EXCEPTION_MESSAGE = "参数异常";
    /**
     * default 请求参数异常
     */
    private static final String REQUEST_PARAM_EXCEPTION_MESSAGE = "请求参数异常 ";

    /**
     * 参数异常
     *
     * @param request 请求体
     * @param e       {@link ParamException}
     * @return msg
     */
    @Order(1)
    @ExceptionHandler({ParamException.class})
    public JsonResult<String> paramException(HttpServletRequest request, Throwable e) {
        String message = e.getMessage();
        if (StringUtils.isBlank(message)) {
            message = PARAM_EXCEPTION_MESSAGE;
        }
        return JsonResult.error(ErrorStatusCode.PARAM_CHECK_ERROR.getStatus(), message);
    }

    /**
     * 业务逻辑异常
     *
     * @param e {@link BusinessCheckException}
     */
    @Order(2)
    @ExceptionHandler({BusinessCheckException.class})
    public JsonResult<String> businessCheckException(HttpServletRequest request, Throwable e) {
        String message = e.getMessage();
        if (StringUtils.isBlank(message)) {
            message = BUSINESS_EXCEPTION_MESSAGE;
        }
        return JsonResult.error(ErrorStatusCode.BUSINESS_CHECK_ERROR.getStatus(), message);
    }

    /**
     * 业务异常
     *
     * @param e {@link BusinessException}
     */
    @Order(3)
    @ExceptionHandler({BusinessException.class})
    public JsonResult<String> businessException(HttpServletRequest request, Throwable e) {
        String message = e.getMessage();
        if (StringUtils.isBlank(message)) {
            message = BUSINESS_EXCEPTION_MESSAGE;
        }
        return JsonResult.error(ErrorStatusCode.BUSINESS_ERROR.getStatus(), message);
    }

    /**
     * JSR - Validate 单个参数验证
     *
     * @param request 请求体
     * @param e       {@link ConstraintViolationException}
     * @return 返回消息
     */
    @Order(4)
    @ExceptionHandler(ConstraintViolationException.class)
    public JsonResult<String> constraintViolationException(HttpServletRequest request, ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream()
                .map(ob -> new StringBuilder(ob.getMessage()).append(","))
                .reduce((ob1, ob2) -> ob1.append(ob2))
                .orElse(new StringBuilder(REQUEST_PARAM_EXCEPTION_MESSAGE)).toString();
        return JsonResult.error(message.substring(0, message.length() - 1));
    }

    /**
     * JSR - Validate 对象绑定异常
     *
     * @param request 请求体
     * @param e       {@link BindException}
     * @return 返回消息
     */
    @Order(5)
    @ExceptionHandler(BindException.class)
    public JsonResult<String> bindException(HttpServletRequest request, BindException e) {
        String message = e.getAllErrors().stream()
                .map(ob -> new StringBuilder(ob.getDefaultMessage()).append(","))
                .reduce((ob1, ob2) -> ob1.append(ob2))
                .orElse(new StringBuilder(REQUEST_PARAM_EXCEPTION_MESSAGE)).toString();
        return JsonResult.error(message.substring(0, message.length() - 1));
    }

    /**
     * JSR - Validate RequestBody 对象参数
     *
     * @param request 请求体
     * @param e       {@link MethodArgumentNotValidException}
     * @return 消息
     * @see org.springframework.web.bind.annotation.RequestBody
     */
    @Order(6)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JsonResult<String> methodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().stream()
                .map(ob -> new StringBuilder(ob.getDefaultMessage()).append(","))
                .reduce((ob1, ob2) -> ob1.append(ob2))
                .orElse(new StringBuilder(REQUEST_PARAM_EXCEPTION_MESSAGE)).toString();
        return JsonResult.error(message.substring(0, message.length() - 1));
    }

    @Order(7)
    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public JsonResult<String> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        log.error("提交方式错误", ex);
        return JsonResult.error(new StringBuilder().append(ex.getMethod()).append(" 提交方式不支持, 仅支持")
                .append(ex.getSupportedHttpMethods()).append("方式提交").toString());
    }

    /**
     * 最后异常处理
     *
     * @param request 请求体
     * @param e       {@link Exception}
     * @return msg
     */
    @Order
    @ExceptionHandler(Exception.class)
    public JsonResult<String> finalException(HttpServletRequest request, Exception e) {
        log.error("系统异常", e);
        return JsonResult.error(SYSTEM_EXCEPTION_MESSAGE);
    }
}
