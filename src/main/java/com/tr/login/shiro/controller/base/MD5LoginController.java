//package com.tr.login.shiro.controller.base;
//
//import com.tr.login.shiro.entity.User;
//import com.tr.login.shiro.jpa.UserJpa;
//import com.tr.login.shiro.utils.MD5Util;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.Objects;
//import java.util.Optional;
//
///**
// * @author rtao
// * @date 2022/1/5 11:03
// */
//@RequestMapping("/md5")
//@RestController
//public class MD5LoginController {
//
//    @Resource
//    UserJpa userJpa;
//
//    @PostMapping("/register")
//    public User register(@RequestBody User user) {
//        user.setPassword(MD5Util.md5(user.getPassword()));
//        return userJpa.save(user);
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestBody User user) {
//        Optional<User> optional = userJpa.findById(user.getUserId());
//        User record = optional.isPresent() ? optional.get(): null;
//        if (Objects.nonNull(record) && record.getPassword().equals(MD5Util.md5(user.getPassword()))) {
//            return "MD5 Login Success ...";
//        }
//        return "MD5 Login Fail !";
//    }
//
//}
