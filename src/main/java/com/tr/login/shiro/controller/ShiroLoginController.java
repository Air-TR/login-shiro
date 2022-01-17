package com.tr.login.shiro.controller;

import com.tr.login.shiro.entity.User;
import com.tr.login.shiro.jpa.UserJpa;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 原文链接：https://www.jianshu.com/p/7f724bec3dc3
 *
 * 项目测试步骤（启动后）：
 *  http://localhost:8080/login?userName=admin&password=123456 —— admin 登录（管理员账户）
 *  http://localhost:8080/index —— 有 index 权限
 *  http://localhost:8080/admin —— 有 admin 权限
 *  http://localhost:8080/add   —— 有 add 权限
 *  http://localhost:8080/login?userName=zhangsan&password=123456 —— zhangsan 登录（普通账户）
 *  http://localhost:8080/index —— 有 index 权限
 *  http://localhost:8080/admin —— 无 admin 权限
 *  http://localhost:8080/add   —— 无 add 权限
 *
 * @author rtao
 * @date 2022/1/6 11:31
 */
@RestController
@Slf4j
public class ShiroLoginController {

    @Resource
    private UserJpa userJpa;

    @GetMapping("/login")
    public String login(User user) {
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            return "请输入用户名和密码！";
        }
        //用户认证信息
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            //进行验证，这里可以捕获异常，然后返回对应信息
            subject.login(token);
//            subject.checkRole("admin");
//            subject.checkPermission("query", "add");
        } catch (UnknownAccountException e) {
            log.error("用户名不存在！", e.getMessage());
            return "用户名不存在！";
        } catch (AuthenticationException e) {
            log.error("账号或密码错误！", e.getMessage());
            return "账号或密码错误！";
        } catch (AuthorizationException e) {
            log.error("没有权限！", e.getMessage());
            return "没有权限";
        }
        return "login success";
    }

    @RequiresRoles("admin")
    @GetMapping("/admin")
    public String admin() {
        return "admin success!";
    }

    @RequiresPermissions("index")
    @GetMapping("/index")
    public String index() {
        return "index success!";
    }

    @RequiresPermissions("add")
    @GetMapping("/add")
    public String add() {
        return "add success!";
    }

}
