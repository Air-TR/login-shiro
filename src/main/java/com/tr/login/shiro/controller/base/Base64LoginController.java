//package com.tr.login.shiro.controller.base;
//
//import com.tr.login.shiro.entity.User;
//import com.tr.login.shiro.jpa.UserJpa;
//import com.tr.login.shiro.utils.Base64Util;
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
// * @date 2022/1/6 11:20
// */
//@RequestMapping("/base64")
//@RestController
//public class Base64LoginController {
//
//    @Resource
//    UserJpa userJpa;
//
//    @PostMapping("/register")
//    public User register(@RequestBody User user) {
//        user.setPassword(Base64Util.encodeBase64(user.getPassword()));
//        return userJpa.save(user);
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestBody User user) {
//        Optional<User> optional = userJpa.findById(user.getUserId());
//        User record = optional.isPresent() ? optional.get(): null;
//        if (Objects.nonNull(record) && Base64Util.decodeBase64(record.getPassword()).equals(user.getPassword())) {
//            return "Base64 Login Success ...";
//        }
//        return "Base64 Login Fail !";
//    }
//
//}
