package com.tr.login.shiro.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 使用注解验证角色和权限无法捕捉异常，从而无法正确返回错误信息给前端，所以加一个类用于拦截异常
 *
 * @author rtao
 * @date 2022/1/13 17:44
 */
@ControllerAdvice
@Slf4j
public class ShiroLoginExceptionHandler {

    @ExceptionHandler
    public String shiroLoginExceptionHandler(AuthorizationException e) {
        log.error("没有通过权限验证！", e.getMessage());
        return "no_permission";
    }
}
